/////////////////////////////////////////////////////////////////////////////
//
// Â© 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.repository.user;

import java.util.Optional;

import org.api.bean.jpa.UserLoginEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * [OVERVIEW] UserLoginDao.
 *
 * @author:  (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)      	 Create new
*/
@Repository
public interface UserLoginRepository extends BaseRepository<UserLoginEntity, Integer> {

    /**
     * Find user login
     * @author (TanDX)
     * @param userId
     * @return the user login entity
     */
    public Optional<UserLoginEntity> findOneById(Integer userId);

//    @Query(value = UserLoginQuery.FIND_USER,
//    countQuery = UserLoginQuery.FIND_USER,
//    nativeQuery = true)
    @Query(value = " SELECT hsmg "
            + " FROM UserLoginEntity hsmg ")
            //+ " WHERE  hsmg.companyId = ( select MAX(hsmg1.companyId) FROM UserLoginEntity hsmg1)")
    Page<UserLoginEntity> findUserLogin(String keyWord, Pageable pageable);

    /**
     * Find user login
     * @author (TanDX)
     * @param userId
     * @return the user login entity
     */
    public UserLoginEntity findOneByUserName(String userName);


}
