/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.transforms;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformOp;

import java.util.Arrays;
import java.util.List;

/**
 * Cube (x^3) elementwise function
 *
 * @author Paul Dubs
 */
public class Cube extends BaseTransformOp {
    public Cube(SameDiff sameDiff, SDVariable i_v, boolean inPlace) {
        super(sameDiff, i_v, inPlace);
    }

    public Cube(SameDiff sameDiff, SDVariable i_v, long[] shape, boolean inPlace, Object[] extraArgs) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
    }

    public Cube(SameDiff sameDiff, SDVariable i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public Cube() {}

    public Cube(INDArray x, INDArray z) {
        super(x, z);
    }

    public Cube(INDArray x, INDArray z, long n) {
        super(x, z, n);
    }

    public Cube(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public Cube(INDArray x, INDArray y, INDArray z) {
        super(x, y, z, x.lengthLong());
    }

    public Cube(INDArray x) {
        super(x);
    }

    @Override
    public int opNum() {
        return 49;
    }

    @Override
    public String opName() {
        return "cube";
    }


    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow opName found for " + opName());
    }


    @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
        SDVariable g = f().mul(f().cubeDerivative(arg()),f1.get(0));
        return Arrays.asList(g);
    }
}
