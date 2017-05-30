package springWebmvc.servlet.mvc.condition;

import java.util.Collection;

public abstract class AbstractRequestCondition<T extends AbstractRequestCondition<T>> implements RequestCondition<T> {

	@Override
	public int hashCode() {
		//return this.getContent().hashCode();
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	
  // protected abstract Collection<?> getContent();
}
