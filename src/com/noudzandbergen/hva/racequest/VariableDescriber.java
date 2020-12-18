package com.noudzandbergen.hva.racequest;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class VariableDescriber<T> {

	public final String displayName, description;
	public final Supplier<T> getter;
	public final Consumer<T> setter;

	public VariableDescriber(String displayName, String description, Supplier<T> getter, Consumer<T> setter) {
		this.displayName = displayName;
		this.description = description;
		this.getter = getter;
		this.setter = setter;
	}

	public T getValue() {
		return getter.get();
	}

	public void setValue(T value) {
		setter.accept(value);
	}

	public String valueToString() {
		return getValue().toString();
	}

	@Override
	public String toString() {
		return displayName + ": " + valueToString();
	}
}
