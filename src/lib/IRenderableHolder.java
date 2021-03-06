package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IRenderableHolder {
	private static final IRenderableHolder startScreenInstance = new IRenderableHolder();
	private static final IRenderableHolder gameScreenInstance = new IRenderableHolder();
	private static final IRenderableHolder tutorialScreenInstance = new IRenderableHolder();
	
	private List<IRenderableObject> entities;
	private Comparator<IRenderableObject> comparator;
	
	public IRenderableHolder() {
		entities = new ArrayList<IRenderableObject>();
		comparator = (IRenderableObject o1, IRenderableObject o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public static IRenderableHolder getStartScreenInstance() {
		return startScreenInstance;
	}

	public static IRenderableHolder getGameScreenInstance() {
		return gameScreenInstance;
	}
	
	public static IRenderableHolder getTutorialScreenInstance() {
		return tutorialScreenInstance;
	}
	
	public void addAndSort(IRenderableObject entity) {
		add(entity);
		sort();
	}
	
	public void add(IRenderableObject entity) {
		entities.add(entity);
		sort();
	}
	
	public void sort(){
		Collections.sort(entities, comparator);
	}

	public List<IRenderableObject> getEntities() {
		return entities;
	}
}
