package com.malfurion.malfurionserver;

import com.malfurion.malfurionserver.common.config.sercurity.service.TokenService;
import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.system.dao.ArticleInfoDao;
import com.malfurion.malfurionserver.system.dao.UserDao;
import com.malfurion.malfurionserver.system.dao.UserLikeDao;
import com.malfurion.malfurionserver.system.dao.impl.UserDaoImpl;
import com.malfurion.malfurionserver.system.mapper.UserMapper;
import com.malfurion.malfurionserver.system.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MalfurionServerApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(MalfurionServerApplicationTests.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDaoImpl userDaoImpl;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenService tokenService;

    @Autowired
    RedisCache redisCache;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ArticleInfoDao articleInfoDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserLikeDao userLikeDao;

/*    @Test
    public void testRedisSet() {
        HashSet<Integer> set = new HashSet<>();
        Set<Object> test = null;
        set.add(1);
        redisCache.setCacheSet("test", set);
        test = redisCache.getCacheSet("test");
        System.out.println(test);
        set.add(2);
        redisCache.setCacheSet("test", set);
        test = redisCache.getCacheSet("test");
        System.out.println(test);
        set.remove(2);
        redisCache.setCacheSet("test", set);
        test = redisCache.getCacheSet("test");
        System.out.println(test);
    }*/
    /*

    @Test
    void testDataBaseConnection() {
        User user = new User();
        user.setUserName("octane");
        user.setPassword("1");
        user.setNickName("o");
        userMapper.insertUser(user);
        //List<User> users = userDao.selectUserList();
        //for (User user : users) {
        //    System.out.println(user);
        //}
    }

    @Test
    void testPasswordEncoding() {
        String password = "cillum Duis dolor1";
        boolean matches = bCryptPasswordEncoder.matches(password, "$2a$10$Wak9/6ToB5sgKB2jAceRjee1Lk8YqG55Mwds5gTsecF0bm/ohsWSS");
        System.out.println(matches);
    }

    @Test
    void testRedisChinese() {
        Collection<String> keys = redisCache.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    void testPageHelper() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectList(null);
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testConvertTree() {
        List<Category> categories = categoryService.selectCategoryList();
        System.out.println(categories);
        CategoryVO categoryVO = categoryService.categoryListToTree(categories);
        System.out.println(categoryVO);
    }

    @Test
    public void redisInfoToDB() {
        Map<String, Object> infoViews = redisCache.getCacheMap("infoViews");
        for (Map.Entry<String, Object> entry : infoViews.entrySet()) {
            ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(Long.parseLong(entry.getKey()));
            if (articleInfo != null) {
                articleInfo.setViews(Integer.parseInt(String.valueOf(entry.getValue())));
                articleInfoDao.updateArticleInfo(articleInfo);
            } else {
                logger.error("不存在此文章");
            }
        }
    }*/

/*    @Test
    public void redisInfoToDB() {
        List<Long> idList = articleInfoDao.selectArticleIdList();
        for (Long id : idList) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setInfoId(id);


            Integer articleInfoLikes = redisCache.getCacheObject("infoLike:" + id);
            if (articleInfoLikes == null) {
                continue;
            }
            articleInfo.setLikes(articleInfoLikes);
            Integer articleInfoViews = redisCache.getCacheObject("infoView:" + id);
            if (articleInfoViews == null) {
                continue;
            }
            articleInfo.setViews(articleInfoViews);
            articleInfoDao.updateArticleInfo(articleInfo);
        }
    }

    @Test
    public void redisUserLikeToDB() {
        List<Long> idList = userDao.selectUserIdList();
        for (Long userId : idList) {
            Set<Long> cacheSet = redisCache.getCacheSet("userLike:" + userId);
            if (cacheSet == null) {
                continue;
            }
            for (Long infoId : cacheSet) {
                UserLike userLike = new UserLike();
                List<Long> userLikes = userLikeDao.selectInfoListByUserId(userId);
                if (!userLikes.contains(infoId)) {
                    userLike.setUserId(userId);
                    userLike.setInfoId(infoId);
                    userLikeDao.insertUserLike(userLike);
                }
            }
        }
    }*/
        /*Map<String, Object> infoViews = redisCache.getCacheMap("infoViews");
        for (Map.Entry<String, Object> entry : infoViews.entrySet()) {
            ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(Long.parseLong(entry.getKey()));
            if (articleInfo != null) {
                articleInfo.setViews(Integer.parseInt(String.valueOf(entry.getValue())));
                articleInfoDao.updateArticleInfo(articleInfo);
            } else {
                logger.error("不存在此文章");
            }
        }*/


}
