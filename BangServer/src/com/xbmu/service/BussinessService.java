package com.xbmu.service;

import java.util.List;

import com.xbmu.bean.Resource;
import com.xbmu.bean.Kind;
import com.xbmu.bean.Post;
import com.xbmu.bean.FavoritesRes;
import com.xbmu.bean.FavoritesPost;
import com.xbmu.bean.User;
import com.xbmu.business.UserBean;
import com.xbmu.business.ResourceBean;
import com.xbmu.business.KindBean;
import com.xbmu.business.PostBean;
import com.xbmu.exception.BangException;
/**
 * 业务层接口(主要声明一些主要的功能)
 * @author Administrator
 *
 */
public interface BussinessService{

	/**
	 * 根据用户名，密码验证登录是否成功
	 * @param username 登录的用户名
 	 * @param pass 登录的密码
	 * @return 登录成功返回用户ID，否则返回-1
	 */
	int validLogin(String username , String pass)
		throws BangException;

	int register(User user)
			throws BangException;
	
	Integer getUserId(String username) throws BangException;
	
	/**
	 * 获取用户信息
	 * @param userId 用户id
	 * @return 用户信息
	 */
	UserBean getUser(Integer userId) throws BangException;
	
	/**
	 * 查询全部种类
	 * @return 系统中全部全部种类
	 */
	List<KindBean> getAllKind() throws BangException;
	
	/**
	 * 添加种类
	 * @param kind 新增的种类
	 * @return 新增种类的主键
	 */
	int addKind(Kind kind) throws BangException;

	/**
	 * 根据种类id获取种类名
	 * @param kindId 种类id;
	 * @return 该种类的名称
	 */
	String getKind(int kindId) throws BangException;
	
	/**
	 * 查询全部资源
	 * @return 全部资源
	 */
	List<ResourceBean> getResources()throws BangException;

	/**
	 * 根据用户查找资源
	 * @param userId 所属者的ID
	 * @return 属于当前用户的资源
	 */
	List<ResourceBean> getResourcesByOwner(Integer userId)
		throws BangException;

	/**
	 * 根据分类查找资源
	 * @param kindId 种类id;
	 * @return 该类的全部资源
	 */
	List<ResourceBean> getResourcesByKind(int kindId) throws BangException;
	
	List<ResourceBean> getResourcesByKey(String key) throws BangException;
	
	/**
	 * 根据资源id，获取资源
	 * @param itemId 资源id;
	 * @return 指定id对应的资源
	 */
	ResourceBean getResource(int resId) throws BangException;
	
	/**
	 * 添加资源
	 * @param resource 新增的资源
	 * @param kindId 种类ID
	 * @param userId 添加者的ID
	 * @return 新增资源的主键
	 */
	int addResource(Resource resource, Integer kindId, Integer userId)
		throws BangException;
	
	/**
	 * 删除资源
	 * @param userId 拥有者ID
	 * @param resId 资源ID
	 */
	void delResourceByUserIdAndResId(Integer userId, Integer resId)
		throws BangException;
	
	/**
	 * 查询全部文章
	 * @return 全部文章
	 */
	List<PostBean> getPosts()throws BangException;

	/**
	 * 根据用户查找文章
	 * @param userId 所属者的ID
	 * @return 属于当前用户的文章
	 */
	List<PostBean> getPostsByOwner(Integer userId)
		throws BangException;

	/**
	 * 根据分类查找文章
	 * @param kindId 种类id;
	 * @return 该类的全部文章
	 */
	List<PostBean> getPostsByKind(int kindId) throws BangException;
	
	/**
	 * 根据文章id，获取文章
	 * @param itemId 文章id;
	 * @return 指定id对应的文章
	 */
	PostBean getPost(int postId) throws BangException;
	
	/**
	 * 添加文章
	 * @param post 新增的文章
	 * @param kindId 种类ID
	 * @param userId 添加者的ID
	 * @return 新增文章的主键
	 */
	int addPost(Post post, Integer kindId, Integer userId)
		throws BangException;
	
	/**
	 * 删除文章
	 * @param userId 拥有者ID
	 * @param postId 文章ID
	 */
	void delPostByUserIdAndResId(Integer userId, Integer postId)
		throws BangException;
	
	/**
	 * 增加文章的感谢数
	 * @param postId 文章id;
	 * @return void
	 */
	void incrPostThx(int postId);
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的文章列表
	 */
	List<PostBean> getFavoritesPostByOwner(Integer userId);
	
	/**
	 * 添加收藏文章
	 * @param favoritesPost 新增的收藏文章
	 * @return 新增文章的主键
	 */
	int addFavoritesPost(FavoritesPost favoritesPost)
		throws BangException;
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的资源列表
	 */
	List<ResourceBean> getFavoritesResByOwner(Integer userId);
	
	/**
	 * 添加收藏资源
	 * @param favoritesRes 新增的收藏资源
	 * @return 新增资源的主键
	 */
	int addFavoritesRes(FavoritesRes favoritesRes)
		throws BangException;
}