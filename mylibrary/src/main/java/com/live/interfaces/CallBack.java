package com.live.interfaces;

public interface CallBack<T> {

    void Success(T data);

    void Fail(String errorMsg);
}
