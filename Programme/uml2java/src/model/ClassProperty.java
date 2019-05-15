package model;

public enum ClassProperty {

	PUBLIC("public"), PRIVATE("private"), STATIC("static"), ABSTRACT("abstract");
	
	String text;
	private ClassProperty(String text) {
	}
	
	public String javaText() {
		
		return text;
	}
	
}
