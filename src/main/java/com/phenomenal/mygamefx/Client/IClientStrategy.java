package com.phenomenal.mygamefx.Client;

import java.io.InputStream;
import java.io.OutputStream;

public interface IClientStrategy {
    public void clientStrategy(InputStream inputStream, OutputStream outputStream);
}