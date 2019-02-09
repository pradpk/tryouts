package pradpk.immutable;

import java.util.Date;

/**
 * Trying to create immutable class
 * @author prakpr7
 *
 */
public final class Immutable {

	private String modifier;
	private final String immutableModifier;
	private Date date;
	
	public Immutable(String val, String modifier) {
		this.immutableModifier = val;
		this.modifier = modifier;
	}

	public String getModifier() {
		return modifier;
	}

	public String getImmutableModifier() {
		return immutableModifier;
	}

	private Date getDate() {
		return (Date) date.clone();
	}
	
	
}
