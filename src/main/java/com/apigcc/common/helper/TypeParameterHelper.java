package com.apigcc.common.helper;

import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.utils.Pair;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TypeParameterHelper {

    /**
     * 获取泛型信息
     * @param referenceType
     * @param index 位置信息
     * @return
     */
    public static Optional<ResolvedType> getTypeParameter(ResolvedReferenceType referenceType, int index){
        List<Pair<ResolvedTypeParameterDeclaration, ResolvedType>> typeParameters = referenceType.getTypeParametersMap();
        if(typeParameters.size()>index){
            Pair<ResolvedTypeParameterDeclaration, ResolvedType> pair = typeParameters.get(index);
            return Optional.of(pair.b);
        }
        return Optional.empty();
    }

    /**
     * 获取泛型信息
     * @param referenceType
     * @param a 如 T E 等
     * @return
     */
    public static Optional<ResolvedType> getTypeParameter(ResolvedReferenceType referenceType, String a){
        List<Pair<ResolvedTypeParameterDeclaration, ResolvedType>> typeParameters = referenceType.getTypeParametersMap();
        for (Pair<ResolvedTypeParameterDeclaration, ResolvedType> pair : typeParameters) {
            if(Objects.equals(pair.a.getName(),a)){
                return Optional.of(pair.b);
            }
        }
        return Optional.empty();
    }
}
