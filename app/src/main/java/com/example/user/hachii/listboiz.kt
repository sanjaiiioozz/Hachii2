package com.example.user.hachii

/**
 * Created by Rpani on 04-Jan-18.
 */

data class MainDish(
        var NameEN: String = "",
        var NameTH: String = "",
        var Price: Double = 0.0,
        var Image: String = "",
        var Id: Int?,
        var RestaurantId: Int?
)

data class SideDish(
        var NameEN: String = "",
        var NameTH: String = "",
        var Price: Double = 0.0,
        var Image: String = "",
        var Id: Int?,
        var RestaurantId: Int?
)

data class Drink(
        var NameEN: String = "",
        var NameTH: String = "",
        var Price: Double = 0.0,
        var Image: String = "",
        var Id: Int?,
        var RestaurantId: Int?
)

data class SetMenu(
        var NameEN: String = "",
        var NameTH: String = "",
        var Price: Double = 0.0,
        var Image: String = "",
        var Id: Int?,
        var RestaurantId: Int?,
        var maindishIds: List<MainDish>? = null,
        var sidedishIds: List<SideDish>? = null,
        var drinkIds: List<Drink>? = null
)

data class Restaurant(
        var restaurantID: Int?,
        var Name: String = "",
        var MerchantId: String = ""
)


data class RestaurantList(
        var RestaurantList: List<Restaurant>
)

data class User(
        var userId: Int?,
        var Username: String = "",
        var Password: String = "",
        var Name: String = "",
        var Image: String = "",
        var PendingOrder: List<Order>,
        var DoneOrder: List<Order>,
        var CancelledOrder: List<Order>
)

data class Order(
        var Id: Int?,
        var UserId: Int?,
        var RestaurantId: Int?,
        var MainDish: List<MainDish>,
        var SideDish: List<SideDish>,
        var Drink: List<Drink>,
        var SetMenu: List<SetMenu>,
        var TotalPrice: Double = 0.0
)

