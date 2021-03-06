package com.rowland.auction.domain.userfeature.repository;

import com.rowland.auction.domain.repository.IRepository;
import com.rowland.auction.domain.userfeature.model.User;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface IUserRepository extends IRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link User}.
     */
    //Observable<List<User>> createUsers();

    /**
     * Get an {@link rx.Observable} which will emit a {@link User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    //Observable<User> updateUser(final int userId);
}
