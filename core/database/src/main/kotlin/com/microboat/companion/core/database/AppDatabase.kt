/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.microboat.companion.core.database.dao.NewsResourceDao
import com.microboat.companion.core.database.dao.NewsResourceFtsDao
import com.microboat.companion.core.database.dao.RecentSearchQueryDao
import com.microboat.companion.core.database.dao.TopicDao
import com.microboat.companion.core.database.dao.TopicFtsDao
import com.microboat.companion.core.database.model.NewsResourceEntity
import com.microboat.companion.core.database.model.NewsResourceFtsEntity
import com.microboat.companion.core.database.model.NewsResourceTopicCrossRef
import com.microboat.companion.core.database.model.RecentSearchQueryEntity
import com.microboat.companion.core.database.model.TopicEntity
import com.microboat.companion.core.database.model.TopicFtsEntity
import com.microboat.companion.core.database.util.InstantConverter

@Database(
    entities = [
        NewsResourceEntity::class,
        NewsResourceTopicCrossRef::class,
        NewsResourceFtsEntity::class,
        TopicEntity::class,
        TopicFtsEntity::class,
        RecentSearchQueryEntity::class,
    ],
    version = 14,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = DatabaseMigrations.Schema2to3::class),
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5),
        AutoMigration(from = 5, to = 6),
        AutoMigration(from = 6, to = 7),
        AutoMigration(from = 7, to = 8),
        AutoMigration(from = 8, to = 9),
        AutoMigration(from = 9, to = 10),
        AutoMigration(from = 10, to = 11, spec = DatabaseMigrations.Schema10to11::class),
        AutoMigration(from = 11, to = 12, spec = DatabaseMigrations.Schema11to12::class),
        AutoMigration(from = 12, to = 13),
        AutoMigration(from = 13, to = 14),
    ],
    exportSchema = true,
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun newsResourceDao(): NewsResourceDao
    abstract fun topicFtsDao(): TopicFtsDao
    abstract fun newsResourceFtsDao(): NewsResourceFtsDao
    abstract fun recentSearchQueryDao(): RecentSearchQueryDao
}
