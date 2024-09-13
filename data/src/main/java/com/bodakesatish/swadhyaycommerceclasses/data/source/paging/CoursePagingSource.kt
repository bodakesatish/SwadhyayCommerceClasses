package com.bodakesatish.swadhyaycommerceclasses.data.source.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.CourseEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.CourseDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import javax.inject.Inject

class CoursePagingSource @Inject constructor(
    private val productDao: CourseDao,
    private val mapper: CourseEntityLocalMapper
) : PagingSource<Int, Course>() {

    private val tag = this.javaClass.simpleName

    init {
        Log.i(tag, "In CoursePagingSource")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Course> {
        Log.i(tag, "In CoursePagingSource load")
        return try {
            val nextPageNumber = params.key ?: 1
            val offset = (nextPageNumber - 1) * params.loadSize
            Log.i(tag, "In CoursePagingSource load params.loadSize->${params.loadSize} offset->$offset")
            val products = productDao.getPagedCourses(params.loadSize, offset)
            val domainProducts = mapper.map(products)

            LoadResult.Page(
                data = domainProducts,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (products.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            Log.i(tag, "In CoursePagingSource load Exception -> ${e.localizedMessage}")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Course>): Int? {
        Log.i(tag, "In CoursePagingSource getRefreshKey -> ${state}")
        // Try to find the page key of the closest page to anchorPosition from
        // either the prevKey or the nextKey; you need to handle nullability
        // here.
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey are null -> anchorPage is the
        //    initial page, so return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        // ... (getRefreshKey implementation)
    }
}