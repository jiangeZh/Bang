package com.xbmu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.xbmu.bean.FavoritesPost;
import com.xbmu.bean.FavoritesRes;
import com.xbmu.bean.Post;
import com.xbmu.bean.Resource;
import com.xbmu.bean.Kind;
import com.xbmu.bean.User;
import com.xbmu.business.UserBean;
import com.xbmu.business.PostBean;
import com.xbmu.business.ResourceBean;
import com.xbmu.business.KindBean;
import com.xbmu.dao.UserDao;
import com.xbmu.dao.ResourceDao;
import com.xbmu.dao.KindDao;
import com.xbmu.dao.PostDao;
import com.xbmu.dao.FavoritesPostDao;
import com.xbmu.dao.FavoritesResDao;
import com.xbmu.dao.impl.UserDaoImpl;
import com.xbmu.dao.impl.ResourceDaoImpl;
import com.xbmu.dao.impl.KindDaoImpl;
import com.xbmu.dao.impl.PostDaoImpl;
import com.xbmu.dao.impl.FavoritesPostDaoImpl;
import com.xbmu.dao.impl.FavoritesResDaoImpl;
import com.xbmu.exception.BangException;
import com.xbmu.service.BussinessService;

public class BussinessServiceImpl implements BussinessService {
	// ---------------------用户----------------------------
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 根据用户名，密码验证登录是否成功
	 * 
	 * @param username
	 *            登录的用户名
	 * @param pass
	 *            登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
	 */
	public int validLogin(String username, String pass) throws BangException {
		User user = userDao.findUserByNameAndPass(username, pass);
		if (user != null) {
			return user.getUser_id();
		}
		return -1;
	}

	public int register(User user) throws BangException {
		int userId = userDao.findUserIdByName(user.getUsername());
		if (userId < 0) { //用户名不存在，可以注册
			return userDao.addUser(user);
		}
		return -1;
	}	
	
	public String getOwner(int ownerId) throws BangException {
		try {
			User user = userDao.get(ownerId);
			if(user!=null){
				return user.getUsername();				
			}
			return null;
		} catch (Exception e) {
			throw new BangException("根据用户id获取用户名称出现异常,请重试");
		}
	}
	
	public Integer getUserId(String username) throws BangException {
		try {
			Integer userId = userDao.findUserIdByName(username);
			return userId; 
		} catch (Exception e) {
			throw new BangException("根据用户id获取用户名称出现异常,请重试");
		}
	}
	
	/**
	 * 获取用户信息
	 * @param userId 用户id
	 * @return 用户信息
	 */
	public UserBean getUser(Integer userId) throws BangException {
		try {
			User user = userDao.get(userId);
			UserBean ib = new UserBean();
			initUser(ib, user);
			return ib;
		} catch (Exception e) {
			throw new BangException("获取用户信息出现异常,请重试");
		}
	}
	
	/**
	 * 将一个User PO转换成UserBean的VO
	 * @param ib  UserBean的VO
	 * @param user User的PO
	 */
	private void initUser(UserBean ib, User user) {
		ib.setUserId(user.getUser_id());
		ib.setUserName(user.getUsername());
		ib.setEmail(user.getEmail());
		ib.setSchoolYear(user.getSchool_year());
		ib.setUserDesc(user.getUser_desc());
		if (user.getRole() != null)	
			ib.setRole(user.getRole());
		if (user.getConcern_kind_id() != null)
			ib.setConcernKindId(user.getConcern_kind_id());
	}
	
	
	// ---------------------资源----------------------------
	private ResourceDao resourceDao = new ResourceDaoImpl();

	/**
	 * 查询全部资源
	 * 
	 * @return 全部资源
	 */
	public List<ResourceBean> getResources() throws BangException {
		try {
			List<Resource> resources = resourceDao.findAllResource();
			List<ResourceBean> result = new ArrayList<ResourceBean>();
			for (Iterator<Resource> it = resources.iterator(); it.hasNext();) {
				ResourceBean ib = new ResourceBean();
				initResource(ib, it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			throw new BangException("查询资源出现异常,请重试");
		}
	}
	
	public List<ResourceBean> getResourcesByKey(String key) throws BangException {
		try {
			List<Resource> resources = resourceDao.findResourceByKey(key);
			List<ResourceBean> result = new ArrayList<ResourceBean>();
			for (Iterator<Resource> it = resources.iterator(); it.hasNext();) {
				ResourceBean ib = new ResourceBean();
				initResource(ib, it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			throw new BangException("查询资源出现异常,请重试");
		}
	}

	//--------------管理资源-----------------------
	//查找自己的资源
	public List<ResourceBean> getResourcesByOwner(Integer userId)
			throws BangException {
		try {
			List<ResourceBean> result = new ArrayList<ResourceBean>();
			List<Resource> resources = resourceDao.findResourceByOwner(userId);
			for(Iterator<Resource> it = resources.iterator();it.hasNext();){
				ResourceBean ib = new ResourceBean();
				initResource(ib, it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户所有的资源出现异常，请重试");
		}
	}
	//添加资源
	public int addResource(Resource resource, Integer kindId, Integer userId)
			throws BangException {
		//设置资源属性
		resource.setDownload_cnt(0);
		resource.setUpload_date(new Date());
		resource.setKind_id(kindId);
		resource.setOwner_id(userId);
		//保存resource对象
		resourceDao.save(resource);
		return resource.getRes_id();
	}
	
	//删除资源
	public void delResourceByUserIdAndResId(Integer userId, Integer resId)
		throws BangException {
		resourceDao.del(userId, resId);
	}
	//---------------根据资源种类选资源--------------
	public List<ResourceBean> getResourcesByKind(int kindId) throws BangException {
		List<ResourceBean> result = new ArrayList<ResourceBean>();
		try {
			List<Resource> resources = resourceDao.findResourceByKind(kindId);
			for(Iterator<Resource> it = resources.iterator();it.hasNext();){
				ResourceBean ib = new ResourceBean();
				initResource(ib,it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BangException("根据种类获取资源出现异常，请重试!");
		}
	}
	
	public ResourceBean getResource(int resId) throws BangException {
		try {
			Resource resource = resourceDao.get(resId);
			ResourceBean ib = new ResourceBean();
			initResource(ib, resource);
			return ib;
		} catch (Exception e) {
			throw new BangException("根据物品id获取资源详细信息出现异常,请重试");
		}
	}
	
	/**
	 * 将一个Resource PO转换成ResourceBean的VO
	 * @param ib  ResourceBean的VO
	 * @param resource Resource的PO
	 */
	private void initResource(ResourceBean ib, Resource resource) {
		ib.setId(resource.getRes_id());
		ib.setName(resource.getRes_name());
		ib.setDesc(resource.getRes_desc());
		ib.setUrl(resource.getRes_url());
		ib.setSize(resource.getRes_size());
		ib.setUploadDate(resource.getUpload_date());
		ib.setDownloadCnt(resource.getDownload_cnt());
		ib.setIsEncrypt(resource.getIs_encrypt());
		if (resource.getIs_encrypt().equals(1))
			ib.setPassword(resource.getPassword());
		if (resource.getKind_id() != null)	
			ib.setKind(getKind(resource.getKind_id()));
		if (resource.getOwner_id() != null)
			ib.setOwner(getOwner(resource.getOwner_id()));
	}
	
	// --------------------种类-------------------------
	private KindDao kindDao = new KindDaoImpl();

	/**
	 * 查询全部种类
	 * 
	 * @return 系统中全部种类
	 */
	public List<KindBean> getAllKind() throws BangException {
		try {
			List<Kind> kindList = kindDao.findAll();
			List<KindBean> result = new ArrayList<KindBean>();
			for (Kind kind : kindList) {
				result.add(new KindBean(kind.getKind_id(), kind.getKind_name(),
						kind.getKind_desc()));
			}
			return result;
		} catch (Exception e) {
			throw new BangException("查询全部种类出现异常,请重试");
		}
	}
	/**
	 * 添加种类
	 * @param kind新增的种类
	 * @return 新增种类的主键
	 */
	public int addKind(Kind kind) throws BangException {
		try {
				kindDao.save(kind);
				return kind.getKind_id();
		} catch (BangException e) {
			throw new BangException("添加种类出现异常,请重试");
		}
	}

	public String getKind(int kindId) throws BangException {
		try {
			Kind kind = kindDao.get(kindId);
			if(kind!=null){
				return kind.getKind_name();				
			}
			return null;
		} catch (Exception e) {
			throw new BangException("根据种类id获取种类名称出现异常,请重试");
		}
	}
	
	// ---------------------文章----------------------------
	private PostDao postDao = new PostDaoImpl();

	/**
	 * 查询全部文章
	 * @return 全部文章
	 */
	public List<PostBean> getPosts()throws BangException {
		try {
			List<Post> posts = postDao.findAllPost();
			List<PostBean> result = new ArrayList<PostBean>();
			for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
				PostBean ib = new PostBean();
				initPost(ib, it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			throw new BangException("查询文章出现异常,请重试");
		}
	}

	//--------------管理文章-----------------------
	/**
	 * 根据用户查找文章
	 * @param userId 所属者的ID
	 * @return 属于当前用户的文章
	 */
	public List<PostBean> getPostsByOwner(Integer userId)
		throws BangException {
		try {
			List<PostBean> result = new ArrayList<PostBean>();
			List<Post> posts = postDao.findPostByOwner(userId);
			for(Iterator<Post> it = posts.iterator();it.hasNext();){
				PostBean ib = new PostBean();
				initPost(ib, it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户所有的文章出现异常，请重试");
		}
	}
	/**
	 * 添加文章
	 * @param post 新增的文章
	 * @param kindId 种类ID
	 * @param userId 添加者的ID
	 * @return 新增文章的主键
	 */
	public int addPost(Post post, Integer kindId, Integer userId)
		throws BangException {
		//设置资源属性
		post.setThx_cnt(0);
		post.setPost_date(new Date());
		post.setKind_id(kindId);
		post.setOwner_id(userId);
		//保存post对象
		postDao.save(post);
		return post.getPost_id();
	}
	
	//删除文章
	public void delPostByUserIdAndResId(Integer userId, Integer resId)
		throws BangException {
		postDao.del(userId, resId);
	}
	/**
	 * 根据分类查找文章
	 * @param kindId 种类id;
	 * @return 该类的全部文章
	 */
	public List<PostBean> getPostsByKind(int kindId) throws BangException {
		List<PostBean> result = new ArrayList<PostBean>();
		try {
			List<Post> posts = postDao.findPostByKind(kindId);
			for(Iterator<Post> it = posts.iterator();it.hasNext();){
				PostBean ib = new PostBean();
				initPost(ib,it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BangException("根据种类获取文章出现异常，请重试!");
		}
	}
	
	/**
	 * 根据文章id，获取文章
	 * @param postId 文章id;
	 * @return 指定id对应的文章
	 */
	public PostBean getPost(int postId) throws BangException {
		try {
			Post post = postDao.get(postId);
			PostBean ib = new PostBean();
			initPost(ib, post);
			return ib;
		} catch (Exception e) {
			throw new BangException("根据物品id获取文章详细信息出现异常,请重试");
		}
	}
	
	/**
	 * 增加文章的感谢数
	 * @param postId 文章id;
	 * @return void
	 */
	public void incrPostThx(int postId) throws BangException {
		try {
			postDao.incrPostThx(postId);
		} catch (Exception e) {
			throw new BangException("增加感谢数出现异常,请重试");
		}
	}
	
	/**
	 * 将一个Post PO转换成PostBean的VO
	 * @param ib  PostBean的VO
	 * @param post Post的PO
	 */
	private void initPost(PostBean ib, Post post) {
		ib.setPostId(post.getPost_id());
		ib.setPostTitle(post.getPost_title());
		ib.setPostText(post.getPost_text());
		ib.setPostDate(post.getPost_date());
		ib.setThxCnt(post.getThx_cnt());
		ib.setImgUrl(post.getImg_url());
		if (post.getKind_id() != null)	
			ib.setKind(getKind(post.getKind_id()));
		if (post.getOwner_id() != null)
			ib.setOwner(getOwner(post.getOwner_id()));
	}
	
	// ---------------------收藏----------------------------
	private FavoritesPostDao favoritesPostDao = new FavoritesPostDaoImpl();
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的文章列表
	 */
	public List<PostBean> getFavoritesPostByOwner(Integer userId) {
		List<PostBean> result = new ArrayList<PostBean>();
		try {
			List<Post> posts = favoritesPostDao.findFavoritesPostByOwner(userId);
			for(Iterator<Post> it = posts.iterator();it.hasNext();){
				PostBean ib = new PostBean();
				initPost(ib,it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BangException("根据用户id获取收藏文章出现异常,请重试");
		}
	}
	
	/**
	 * 添加收藏文章
	 * @param favoritesPost 新增的收藏文章
	 * @return 新增文章的主键
	 */
	public int addFavoritesPost(FavoritesPost favoritesPost) 
			throws BangException {
		favoritesPostDao.save(favoritesPost);
		return favoritesPost.getPost_id();
	}
	
	private FavoritesResDao favoritesResDao = new FavoritesResDaoImpl();
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的资源列表
	 */
	public List<ResourceBean> getFavoritesResByOwner(Integer userId) {
		List<ResourceBean> result = new ArrayList<ResourceBean>();
		try {
			List<Resource> resources = favoritesResDao.findFavoritesResByOwner(userId);
			for(Iterator<Resource> it = resources.iterator();it.hasNext();){
				ResourceBean ib = new ResourceBean();
				initResource(ib,it.next());
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BangException("根据用户id获取收藏文章出现异常,请重试");
		}
	}
	
	/**
	 * 添加收藏资源
	 * @param favoritesRes 新增的收藏资源
	 * @return 新增资源的主键
	 */
	public int addFavoritesRes(FavoritesRes favoritesRes) 
			throws BangException {
		favoritesResDao.save(favoritesRes);
		return favoritesRes.getRes_id();
	}
}
