package monim.blackice.business.data

import android.content.Context
import monim.blackice.business.data.local_db.IRoomHelper
import monim.blackice.business.data.local_db.entity.User
import monim.blackice.business.data.model.CurrentUserInfo
import monim.blackice.business.data.network.ApiHelper
import monim.blackice.business.data.prefence.IPreferenceHelper
import sslwireless.android.easy.loyal.merchant.viewmodel.util.ApiCallbackHelper

class DataManager(
    context: Context,
    dbRoomHelper: IRoomHelper,
    preferencesHelper: IPreferenceHelper,
    apiHelper: ApiHelper
) : IDataManager {
    private val context = context

    val dbRoomHelper = dbRoomHelper
    val preferencesHelper = preferencesHelper
    val apiHelper = apiHelper
    override fun PrefGetCurrentUser(): monim.blackice.business.data.model.user.User {
        return preferencesHelper.PrefGetCurrentUser()
    }


    override fun apiLogin(msisdn: String, password: String,apiCallbackHelper: ApiCallbackHelper) {
        apiHelper.apiLogin(msisdn,password,apiCallbackHelper)
    }

    override fun PrefLogin(user: monim.blackice.business.data.model.user.User) {
        preferencesHelper.PrefLogin(user)
    }

    override fun PrefLogout() {
        preferencesHelper.PrefLogout()
    }

    override fun PrefGetLoginMode(): Boolean {
        return preferencesHelper.PrefGetLoginMode()
    }

    override fun roomGetAllUser(): List<User> {
        return dbRoomHelper.roomGetAllUser()
    }

    override fun roomGetUserById(localId: Int) {
        dbRoomHelper.roomGetUserById(localId)
    }

    override fun roomInsertUser(users: List<User>) {
        dbRoomHelper.roomInsertUser(users)
    }

    override fun roomInsertUser(user: User) {
        dbRoomHelper.roomInsertUser(user)
    }

    override fun deleteUser(users: List<User>): Boolean {
        return dbRoomHelper.deleteUser(users)
    }

    override fun deleteUser(users: User): Boolean {
        return dbRoomHelper.deleteUser(users)
    }

    override fun deleteUser(): Boolean {
        return dbRoomHelper.deleteUser()
    }
}