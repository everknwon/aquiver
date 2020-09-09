/*
 * MIT License
 *
 * Copyright (c) 2019 1619kHz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.aquiver.result;

import io.netty.handler.codec.http.FullHttpResponse;
import org.aquiver.RequestContext;
import org.aquiver.ResultHandler;
import org.aquiver.ResultResponseBuilder;
import org.aquiver.mvc.RequestResult;

/**
 * @author WangYi
 * @since 2020/8/22
 */
public final class VoidResultHandler implements ResultHandler {

  @Override
  public boolean support(RequestResult requestResult) {
    return Void.TYPE.isAssignableFrom(requestResult.getResultType());
  }

  @Override
  public void handle(RequestContext ctx, RequestResult result) {
    FullHttpResponse voidResponse = ResultResponseBuilder.forResponse().build();
    ctx.writeAndFlush(voidResponse);
  }
}
