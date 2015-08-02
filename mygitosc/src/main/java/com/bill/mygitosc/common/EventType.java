package com.bill.mygitosc.common;

/**
 * Created by liaobb on 2015/7/31.
 */
public class EventType {
    /** ��̬������*/
    public final static byte EVENT_TYPE_CREATED   = 0x1;// ������issue
    public final static byte EVENT_TYPE_UPDATED   = 0x2;// ������Ŀ
    public final static byte EVENT_TYPE_CLOSED    = 0x3;// �ر���Ŀ
    public final static byte EVENT_TYPE_REOPENED  = 0x4;// ���´�����Ŀ
    public final static byte EVENT_TYPE_PUSHED    = 0x5;// push
    public final static byte EVENT_TYPE_COMMENTED = 0x6;// ����
    public final static byte EVENT_TYPE_MERGED    = 0x7;// �ϲ�
    public final static byte EVENT_TYPE_JOINED    = 0x8; //# User joined project
    public final static byte EVENT_TYPE_LEFT      = 0x9; //# User left project
    public final static byte EVENT_TYPE_FORKED    = 0xb;// fork����Ŀ
}
