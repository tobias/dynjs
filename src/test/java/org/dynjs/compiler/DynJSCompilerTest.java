package org.dynjs.compiler;

import me.qmx.jitescript.CodeBlock;
import org.dynjs.api.Function;
import org.dynjs.runtime.Argument;
import org.dynjs.runtime.DynAtom;
import org.dynjs.runtime.DynFunction;
import org.dynjs.runtime.DynString;
import org.junit.Before;
import org.junit.Test;

import static me.qmx.jitescript.util.CodegenUtils.p;
import static me.qmx.jitescript.util.CodegenUtils.sig;
import static org.fest.assertions.Assertions.assertThat;


public class DynJSCompilerTest {

    private DynJSCompiler dynJSCompiler;

    @Before
    public void setUp() throws Exception {
        dynJSCompiler = new DynJSCompiler();
    }

    @Test
    public void testCompile() throws Exception {
        DynString dynString = new DynString("hello dynjs");
        DynFunction dynFunction = new DynFunction(new Argument("a", dynString)) {

            @Override
            public CodeBlock getCodeBlock() {
                return CodeBlock.newCodeBlock()
                        .aload(1)
                        .iconst_0()
                        .aaload()
                        .areturn();
            }


        };
        Function function = dynJSCompiler.compile(dynFunction);
        DynAtom result = function.call(new DynAtom[]{dynString});
        assertThat(result)
                .isNotNull()
                .isInstanceOf(DynString.class);

    }
}