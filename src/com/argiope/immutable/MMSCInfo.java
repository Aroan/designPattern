package com.argiope.immutable;

/**
 * 彩信中心信息
 * 模式角色ImmutableObject.immutableObject
 * Created by leeXiang on 2017/1/20.
 */
public final class MMSCInfo {
    /**
     * 设备编号
     */
    private final String deviceId;
    /**
     * 彩信中心URL
     */
    private final String url;
    /**
     * 彩信中允许的最大附件大小
     */
    private final int maxAttachmentSizeInBytes;

    public MMSCInfo(String deviceId, String url, int maxAttachmentSizeInBytes) {
        this.deviceId = deviceId;
        this.url = url;
        this.maxAttachmentSizeInBytes = maxAttachmentSizeInBytes;
    }

    public MMSCInfo(MMSCInfo prototype) {
        this.deviceId = prototype.getDeviceId();
        this.url = prototype.getUrl();
        this.maxAttachmentSizeInBytes = prototype.getMaxAttachmentSizeInBytes();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxAttachmentSizeInBytes() {
        return maxAttachmentSizeInBytes;
    }
}
