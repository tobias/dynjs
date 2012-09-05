package org.dynjs.runtime.builtins.math;

import org.dynjs.runtime.AbstractNativeFunction;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.GlobalObject;
import org.dynjs.runtime.builtins.Math;
import org.dynjs.runtime.builtins.types.number.DynNumber;

public class Cos extends AbstractNativeFunction {

    public Cos(GlobalObject globalObject) {
        super(globalObject, "x");
    }

    @Override
    public Object call(ExecutionContext context, Object self, Object... args) {
        if (DynNumber.isNaN(args[0])) {
            return Double.NaN;
        }
        final Double arg = Math.functionArgToDouble(context, args[0]);
        if (arg == 0) {
            return 1;
        }
        return java.lang.Math.cos(arg);
    }

}
