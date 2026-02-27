package org.example.swaqqerapi_study.common.exception;

import lombok.Getter;
import org.example.swaqqerapi_study.common.model.BaseResponseStatus;

@Getter
public class BaseException extends RuntimeException {
    private BaseResponseStatus status;

  public BaseException(BaseResponseStatus status) {
      super(status.getMessage());
      this.status = status;
  }

  public static BaseException from(BaseResponseStatus status) {
      return new BaseException(status);
  }
}
