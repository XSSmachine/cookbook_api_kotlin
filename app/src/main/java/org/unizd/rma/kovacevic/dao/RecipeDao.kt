package org.unizd.rma.kovacevic.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.unizd.rma.kovacevic.entitiy.CategoryItems
import org.unizd.rma.kovacevic.entitiy.MealsItems

@Dao
interface RecipeDao {

    @Query("SELECT DISTINCT * FROM categoryitems ORDER BY id DESC")
    suspend fun getAllCategory() : List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: CategoryItems?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(mealsItems: MealsItems?)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()

    @Query("SELECT DISTINCT * FROM MealItems WHERE categoryName = :categoryName")
    suspend fun getSpecificMealList(categoryName: String): List<MealsItems>

    @Query("SELECT * FROM CategoryItems WHERE strcategory = :categoryName LIMIT 1")
    suspend fun getCategoryByName(categoryName: String): CategoryItems?

    @Query("SELECT * FROM MealItems WHERE idMeal = :mealId")
    fun getMealById(mealId: String): MealsItems?



}