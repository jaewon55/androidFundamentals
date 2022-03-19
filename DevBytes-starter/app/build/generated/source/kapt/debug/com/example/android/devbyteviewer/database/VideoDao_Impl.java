package com.example.android.devbyteviewer.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class VideoDao_Impl implements VideoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfDatabaseVideo;

  public VideoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDatabaseVideo = new EntityInsertionAdapter<DatabaseVideo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `DatabaseVideo`(`url`,`updated`,`title`,`description`,`thumbnail`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DatabaseVideo value) {
        if (value.getUrl() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUrl());
        }
        if (value.getUpdated() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUpdated());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getThumbnail());
        }
      }
    };
  }

  @Override
  public void insertAll(final List<DatabaseVideo> videos) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDatabaseVideo.insert(videos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<DatabaseVideo>> getVideos() {
    final String _sql = "select * from databasevideo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"databasevideo"}, false, new Callable<List<DatabaseVideo>>() {
      @Override
      public List<DatabaseVideo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final List<DatabaseVideo> _result = new ArrayList<DatabaseVideo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabaseVideo _item;
            _item = __entityCursorConverter_comExampleAndroidDevbyteviewerDatabaseDatabaseVideo(_cursor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  private DatabaseVideo __entityCursorConverter_comExampleAndroidDevbyteviewerDatabaseDatabaseVideo(
      Cursor cursor) {
    final DatabaseVideo _entity;
    final int _cursorIndexOfUrl = cursor.getColumnIndex("url");
    final int _cursorIndexOfUpdated = cursor.getColumnIndex("updated");
    final int _cursorIndexOfTitle = cursor.getColumnIndex("title");
    final int _cursorIndexOfDescription = cursor.getColumnIndex("description");
    final int _cursorIndexOfThumbnail = cursor.getColumnIndex("thumbnail");
    final String _tmpUrl;
    if (_cursorIndexOfUrl == -1) {
      _tmpUrl = null;
    } else {
      _tmpUrl = cursor.getString(_cursorIndexOfUrl);
    }
    final String _tmpUpdated;
    if (_cursorIndexOfUpdated == -1) {
      _tmpUpdated = null;
    } else {
      _tmpUpdated = cursor.getString(_cursorIndexOfUpdated);
    }
    final String _tmpTitle;
    if (_cursorIndexOfTitle == -1) {
      _tmpTitle = null;
    } else {
      _tmpTitle = cursor.getString(_cursorIndexOfTitle);
    }
    final String _tmpDescription;
    if (_cursorIndexOfDescription == -1) {
      _tmpDescription = null;
    } else {
      _tmpDescription = cursor.getString(_cursorIndexOfDescription);
    }
    final String _tmpThumbnail;
    if (_cursorIndexOfThumbnail == -1) {
      _tmpThumbnail = null;
    } else {
      _tmpThumbnail = cursor.getString(_cursorIndexOfThumbnail);
    }
    _entity = new DatabaseVideo(_tmpUrl,_tmpUpdated,_tmpTitle,_tmpDescription,_tmpThumbnail);
    return _entity;
  }
}
