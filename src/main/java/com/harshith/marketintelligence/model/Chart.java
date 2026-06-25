package com.harshith.marketintelligence.model;

import java.util.List;

public class Chart {

    private List<Result> result;
    private Object error;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}