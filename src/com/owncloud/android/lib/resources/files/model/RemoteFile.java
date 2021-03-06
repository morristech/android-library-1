/* ownCloud Android Library is available under MIT license
 *   Copyright (C) 2015 ownCloud Inc.
 *   
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *   
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *   
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 *   EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *   MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 *   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 *   BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN 
 *   ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 *
 */

package com.owncloud.android.lib.resources.files.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.owncloud.android.lib.common.network.WebdavEntry;
import com.owncloud.android.lib.resources.files.FileUtils;

import java.io.Serializable;

/**
 * Contains the data of a Remote File from a WebDavEntry.
 *
 * @author masensio
 */
public class RemoteFile implements Parcelable, Serializable {

    /**
     * Generated - should be refreshed every time the class changes!!
     */
    private static final long serialVersionUID = 3130865437811248451L;

    private String mRemotePath;
    private String mMimeType;
    private long mLength;
    private long mCreationTimestamp;
    private long mModifiedTimestamp;
    private String mEtag;
    private String mPermissions;
    private String mRemoteId;
    private long mSize;
    private boolean mIsFavorite;
    private boolean mIsEncrypted;
    private WebdavEntry.MountType mMountType;
    private String ownerId;
    private String ownerDisplayName;
    private int unreadCommentsCount;
    private boolean hasPreview;
    private String note;

    /**
     * Getters and Setters.
     */

    public boolean getIsFavorite() {
        return mIsFavorite;
    }

    public void setFavorite(boolean mIsFavorite) {
        this.mIsFavorite = mIsFavorite;
    }

    public boolean getIsEncrypted() {
        return mIsEncrypted;
    }

    public void setIsEncrypted(boolean mIsEncrypted) {
        this.mIsEncrypted = mIsEncrypted;
    }

    public String getRemotePath() {
        return mRemotePath;
    }

    public void setRemotePath(String remotePath) {
        this.mRemotePath = remotePath;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public void setMimeType(String mimeType) {
        this.mMimeType = mimeType;
    }

    public long getLength() {
        return mLength;
    }

    public void setLength(long length) {
        this.mLength = length;
    }

    public long getCreationTimestamp() {
        return mCreationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.mCreationTimestamp = creationTimestamp;
    }

    public long getModifiedTimestamp() {
        return mModifiedTimestamp;
    }

    public void setModifiedTimestamp(long modifiedTimestamp) {
        this.mModifiedTimestamp = modifiedTimestamp;
    }

    public String getEtag() {
        return mEtag;
    }

    public void setEtag(String etag) {
        this.mEtag = etag;
    }

    public String getPermissions() {
        return mPermissions;
    }

    public void setPermissions(String permissions) {
        this.mPermissions = permissions;
    }

    public String getRemoteId() {
        return mRemoteId;
    }

    public void setRemoteId(String remoteId) {
        this.mRemoteId = remoteId;
    }

    public long getSize() {
        return mSize;
    }

    public void setSize(long size) {
        mSize = size;
    }

    public WebdavEntry.MountType getMountType() {
        return mMountType;
    }

    public void setMountType(WebdavEntry.MountType mountType) {
        this.mMountType = mountType;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    public void setUnreadCommentsCount(int unreadCommentsCount) {
        this.unreadCommentsCount = unreadCommentsCount;
    }

    public int getUnreadCommentsCount() {
        return unreadCommentsCount;
    }

    public boolean hasPreview() {
        return hasPreview;
    }

    public void setHasPreview(boolean hasPreview) {
        this.hasPreview = hasPreview;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public RemoteFile() {
        resetData();
    }

    /**
     * Create new {@link RemoteFile} with given path.
     *
     * The path received must be URL-decoded. Path separator must be OCFile.PATH_SEPARATOR, and it must be the first character in 'path'.
     *
     * @param path The remote path of the file.
     */
    public RemoteFile(String path) {
        resetData();
        if (path == null || path.length() <= 0 || !path.startsWith(FileUtils.PATH_SEPARATOR)) {
            throw new IllegalArgumentException("Trying to create a OCFile with a non valid remote path: " + path);
        }
        mRemotePath = path;
    }

    public RemoteFile(WebdavEntry we) {
        this(we.decodedPath());
        setCreationTimestamp(we.createTimestamp());
        setLength(we.contentLength());
        setMimeType(we.contentType());
        setModifiedTimestamp(we.modifiedTimestamp());
        setEtag(we.etag());
        setPermissions(we.permissions());
        setRemoteId(we.remoteId());
        setSize(we.size());
        setFavorite(we.isFavorite());
        setMountType(we.getMountType());
        setOwnerId(we.getOwnerId());
        setOwnerDisplayName(we.getOwnerDisplayName());
        setNote(we.getNote());
    }

    /**
     * Used internally. Reset all file properties
     */
    private void resetData() {
        mRemotePath = null;
        mMimeType = null;
        mLength = 0;
        mCreationTimestamp = 0;
        mModifiedTimestamp = 0;
        mEtag = null;
        mPermissions = null;
        mRemoteId = null;
        mSize = 0;
        mIsFavorite = false;
        mIsEncrypted = false;
        ownerId = "";
        ownerDisplayName = "";
        note = "";
    }

    /**
     * Parcelable Methods
     */
    public static final Parcelable.Creator<RemoteFile> CREATOR
            = new Parcelable.Creator<RemoteFile>() {
        @Override
        public RemoteFile createFromParcel(Parcel source) {
            return new RemoteFile(source);
        }

        @Override
        public RemoteFile[] newArray(int size) {
            return new RemoteFile[size];
        }
    };


    /**
     * Reconstruct from parcel
     *
     * @param source The source parcel
     */
    protected RemoteFile(Parcel source) {
        readFromParcel(source);
    }

    public void readFromParcel(Parcel source) {
        mRemotePath = source.readString();
        mMimeType = source.readString();
        mLength = source.readLong();
        mCreationTimestamp = source.readLong();
        mModifiedTimestamp = source.readLong();
        mEtag = source.readString();
        mPermissions = source.readString();
        mRemoteId = source.readString();
        mSize = source.readLong();
        mIsFavorite = Boolean.parseBoolean(source.readString());
        mIsEncrypted = Boolean.parseBoolean(source.readString());
        mMountType = (WebdavEntry.MountType) source.readSerializable();
        ownerId = source.readString();
        ownerDisplayName = source.readString();
        hasPreview = Boolean.parseBoolean(source.readString());
        note = source.readString();
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mRemotePath);
        dest.writeString(mMimeType);
        dest.writeLong(mLength);
        dest.writeLong(mCreationTimestamp);
        dest.writeLong(mModifiedTimestamp);
        dest.writeString(mEtag);
        dest.writeString(mPermissions);
        dest.writeString(mRemoteId);
        dest.writeLong(mSize);
        dest.writeString(Boolean.toString(mIsFavorite));
        dest.writeString(Boolean.toString(mIsEncrypted));
        dest.writeSerializable(mMountType);
        dest.writeString(ownerId);
        dest.writeString(ownerDisplayName);
        dest.writeString(Boolean.toString(hasPreview));
        dest.writeString(note);
    }
}
