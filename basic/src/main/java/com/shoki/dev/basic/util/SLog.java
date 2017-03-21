package com.shoki.dev.basic.util;

import android.os.Bundle;
import android.util.Log;

import java.util.Iterator;

public class SLog {

    public static final boolean writeLog = true;
    private static String TAG = "";

    public static void init(String tag) {
        TAG = tag;
    }

    public static void init() {
        init("Shoki");
    }

    public static void verbose(String log) {
        if (writeLog) {
            LogVO logVO = generateLogVO(2);

            if (logVO != null) {
                Log.v(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + log);
            }
        }
    }

    public static void debug(String log) {
        if (writeLog) {
            LogVO logVO = generateLogVO(2);

            if (logVO != null) {
                Log.d(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + log);
            }
        }
    }

    public static void info(String log) {
        if (writeLog) {
            LogVO logVO = generateLogVO(2);

            if (logVO != null) {
                Log.i(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + log);
            }
        }
    }

    public static void warn(String log) {
        if (writeLog) {
            LogVO logVO = generateLogVO(2);

            if (logVO != null) {
                Log.w(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + log);
            }
        }
    }

    public static void error(String log) {
        if (writeLog) {
            LogVO logVO = generateLogVO(2);

            if (logVO != null) {
                Log.e(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + log);
            }
        }
    }

    public static void values(Bundle bundle) {
        Iterator<String> keySet = bundle.keySet().iterator();

        while (keySet.hasNext()) {
            String key = keySet.next();
            if (writeLog) {
                LogVO logVO = generateLogVO(2);

                if (logVO != null) {
                    Log.v(TAG, "[" + logVO.getClassName() + "] " + logVO.getMethodName() + "()" + "[" + logVO.getLineNumber() + "]" + " >> " + "[" + key + "] : " + bundle.get(key));
                }
            }
        }
    }

    private static LogVO generateLogVO(int depth) {
        String tag = "";
        String temp = new Throwable().getStackTrace()[depth].getClassName();

        if (temp != null) {
            int lastDotPos = temp.lastIndexOf(".");
            tag = temp.substring(lastDotPos + 1);
        }

        String methodName = new Throwable().getStackTrace()[depth].getMethodName();
        int lineNumber = new Throwable().getStackTrace()[depth].getLineNumber();

        LogVO logVO = new LogVO();
        logVO.setClassName(tag);
        logVO.setMethodName(methodName);
        logVO.setLineNumber(lineNumber);

        return logVO;
    }

    static class LogVO {
        private String className;
        private String methodName;
        private int lineNumber;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }
    }
}
