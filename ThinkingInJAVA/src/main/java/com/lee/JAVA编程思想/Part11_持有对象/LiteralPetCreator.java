package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.lee.JAVA编程思想.Part14_类型信息.Pet;
import com.lee.JAVA编程思想.Part14_类型信息.PetCreator;

public class LiteralPetCreator extends PetCreator
{
	public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
//			Pet.class,Dog.class...
	));

	private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Pet.class),allTypes.size());
	@Override
	public List<Class<? extends Pet>> types() {
		return types();
	}
}
