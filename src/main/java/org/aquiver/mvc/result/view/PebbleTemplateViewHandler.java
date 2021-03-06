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
package org.aquiver.mvc.result.view;

import io.netty.handler.codec.http.FullHttpResponse;
import org.aquiver.RequestContext;
import org.aquiver.ResponseBuilder;
import org.aquiver.ServerSpec;
import org.aquiver.ViewHandlerType;
import org.aquiver.mvc.router.views.HTMLView;
import org.aquiver.mvc.router.views.PebbleHTMLView;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author WangYi
 * @since 2020/8/23
 */
public final class PebbleTemplateViewHandler extends AbstractTemplateViewHandler {
  private final HTMLView htmlView = new PebbleHTMLView();

  @Override
  public String getPrefix() {
    return environment.get(ServerSpec.PATH_SERVER_VIEW_PREFIX, "");
  }

  @Override
  protected void doRender(RequestContext ctx, String viewPathName) throws IOException {
    String renderView = this.htmlView.renderView(viewPathName, new HashMap<>());
    final FullHttpResponse responseView = ResponseBuilder.builder().body(renderView).build();
    ctx.tryPush(responseView);
  }

  @Override
  public String getSuffix() {
    return ".peb";
  }

  @Override
  public String getType() {
    return "peb";
  }

  @Override
  public ViewHandlerType getHandlerType() {
    return ViewHandlerType.TEMPLATE_VIEW;
  }
}
