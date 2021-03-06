/*
 * Copyright (c) 2020 Proton Technologies AG
 * 
 * This file is part of ProtonMail.
 * 
 * ProtonMail is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ProtonMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ProtonMail. If not, see https://www.gnu.org/licenses/.
 */
package ch.protonmail.android.api.models.room.sendingFailedNotifications

import androidx.room.*

@Dao
abstract class SendingFailedNotificationsDatabase {

    @Query("SELECT * FROM SendingFailedNotification WHERE message_id = :messageId")
    abstract fun findByMessageId(messageId: String): SendingFailedNotification?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSendingFailedNotification(sendingFailedNotification: SendingFailedNotification)

    @Query("SELECT COUNT(${COLUMN_SENDING_FAILED_NOTIFICATION_MESSAGE_ID}) FROM $TABLE_SENDING_FAILED_NOTIFICATION")
    abstract fun count(): Int

    @Query("SELECT * FROM SendingFailedNotification")
    abstract fun findAllSendingFailedNotifications(): List<SendingFailedNotification>

    @Query("DELETE FROM SendingFailedNotification WHERE message_id = :messageId")
    abstract fun deleteByMessageId(messageId: String)

    @Delete
    abstract fun deleteSendingFailedNotifications(notifications: List<SendingFailedNotification>)

    @Query("DELETE FROM SendingFailedNotification")
    abstract fun clearSendingFailedNotifications()

}