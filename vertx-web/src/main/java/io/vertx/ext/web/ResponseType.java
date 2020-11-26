package io.vertx.ext.web;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;

@VertxGen
public interface ResponseType<T> {

  static <T> ResponseType<T> json() {
    return json(null);
  }

  static <T> ResponseType<T> json(String charset) {
    return new ResponseType<T>() {

      @Override
      public String contentType() {
        if (charset != null) {
          return "application/json; charset=" + charset;
        } else {
          return "application/json";
        }
      }

      @Override
      public Buffer encode(T body) {
        return Json.encodeToBuffer(body);
      }
    };
  }

  String contentType();

  Buffer encode(T body);
}
