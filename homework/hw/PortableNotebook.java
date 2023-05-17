package hw;

public class PortableNotebook implements Notebook, Tablet {
	int mode;
	String documentaion;
	String internet;
	String video;
	String app;
	
	PortableNotebook(){
		this.mode = Notebook.NOTEBOOK_MODE;
		System.out.println("NOTEBOOK_MODE");
	}
	
	@Override
	public void writeDocumentaion(String documentaion) {
		System.out.println(documentaion + "을 통해 문서를 작성.");
		
	}

	@Override
	public void searchInternet(String internet) {
		System.out.println(internet + "를 통해 인터넷을 검색.");
		
	}
	
	@Override
	public void watchVideo(String video) {
		System.out.println(video + "를 시청.");
		
	}
	
	@Override
	public void useApp(String app) {
		if(mode==1) {
			this.mode = Tablet.TABLET_MODE;
		}
		System.out.println(app + "를 실행.");
	}
	
	public void changeMode() {
		if(mode==1) {
			this.mode = Tablet.TABLET_MODE;
			System.out.println("TABLET_MODE");
		} else if(mode==2) {
			this.mode = Notebook.NOTEBOOK_MODE;
			System.out.println("NOTEBOOK_MODE");
		}
	}
}
