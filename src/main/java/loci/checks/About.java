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

import javax.swing.JOptionPane;

/**
 * Displays a small information dialog about this package.
 *
 * @author Curtis Rueden
 */
public final class About {

  /** URL of LOCI Software web page. */
  public static final String URL_LOCI_SOFTWARE =
    "http://www.loci.wisc.edu/software";

  /** URL of Checkstyle web page. */
  public static final String URL_CHECKSTYLE =
    "http://checkstyle.sourceforge.net/";

  private About() {
    // prevent instantiation of utility class
  }

  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null,
      "LOCI Checkstyle checks, revision @svn.revision@, built @date@\n" +
      "Download Checkstyle from " + URL_CHECKSTYLE + "\n" +
      "Download LOCI software from " + URL_LOCI_SOFTWARE,
      "LOCI Checkstyle checks", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }

}
