/*
 * Copyright(c)  2019 Aashish Aadarsh
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 *    @author : Aashish Aadarsh
 *    Follow Me:  "https://github.com/aashish-aadarsh"
 */

package com.devop.aashish.android.datasource.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.devop.aashish.android.datasource.database.entity.RequestCascadeEntity


@Dao
interface RequestCascadeDao : BaseDao<RequestCascadeEntity> {

    @Query("select * from request_cascade")
    fun fetchAll(): LiveData<List<RequestCascadeEntity>>

    @Query("select * from request_cascade where requestCascadeId = :requestCascadeId")
    fun findByRequestCascadeId(requestCascadeId: String): RequestCascadeEntity

    @Query("select * from request_cascade where requestCascadeId = :requestCascadeId and cascadeProcessingStatus= :cascadeStatus")
    fun findByRequestCascadeIdAndStatus(requestCascadeId: String, cascadeStatus: String): RequestCascadeEntity

    @Query("select * from request_cascade where cascadeProcessingStatus= :cascadeStatus")
    fun findByRequestCascadeStatus(cascadeStatus: String): List<RequestCascadeEntity>
}