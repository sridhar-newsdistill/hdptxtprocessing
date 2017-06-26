package com.newsdistill.hadoopdemo;

import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
  static{
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
  }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
