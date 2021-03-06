/*
 * #%L
 * LOCI Checkstyle checks.
 * %%
 * Copyright (C) 2006 - 2014 Board of Regents of the University of
 * Wisconsin-Madison.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package loci.checks;

import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

/**
 * A Checkstyle check for identifying multiple consecutive blank lines.
 *
 * @author Curtis Rueden
 */
public class BlankLinesCheck extends Check {

  // -- Fields --

  /** Maximum allowed number of consecutive blank lines. */
  private int max = 1;

  // -- BlankLinesCheck API methods --

  /** Sets the maximum allowed number of consecutive blank lines. */
  public void setMax(final int max) { this.max = max; }

  // -- Check API methods --

  @Override
  public int[] getDefaultTokens() {
    return new int[0];
  }

  @Override
  public void beginTree(final DetailAST aRootAST) {
    String[] lines = getLines();
    int count = 0;
    for (int i=0; i<lines.length; i++) {
      boolean blank = lines[i].trim().equals("");
      if (blank) count++;
      else {
        if (count > max) {
          log(i - count + 1, 0, "blank.lines",
            new Object[] {new Integer(count)});
        }
        count = 0;
      }
    }
  }

}
