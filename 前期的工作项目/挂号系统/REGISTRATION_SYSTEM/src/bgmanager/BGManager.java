package bgmanager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import pdtableDAOImpl.PDtableDAOImpl;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class BGManager {

	protected Shell addoctor;
	private Text doctornametext;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BGManager window = new BGManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		addoctor.open();
		addoctor.layout();
		while (!addoctor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		PDtableDAOImpl pdtableimpl = new PDtableDAOImpl();
		Managermainpage window03 = new	Managermainpage();
		addoctor = new Shell();
		addoctor.setSize(450, 300);
		addoctor.setText("\u6DFB\u52A0\u533B\u751F");
		addoctor.setLayout(new FormLayout());
		
		
		Combo subject = new Combo(addoctor, SWT.NONE);
		subject.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FormData fd_subject = new FormData();
		fd_subject.top = new FormAttachment(30);
		fd_subject.left = new FormAttachment(50);
		subject.setLayoutData(fd_subject);
		subject.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		subject.setText("\u79D1\u5BA4\uFF1F");
		
		Label subjectlabel = new Label(addoctor, SWT.NONE);
		FormData fd_subjectlabel = new FormData();
		fd_subjectlabel.top = new FormAttachment(30);
		fd_subjectlabel.left = new FormAttachment(45);
		subjectlabel.setLayoutData(fd_subjectlabel);
		subjectlabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		subjectlabel.setText("\u79D1\u5BA4");
		
		Label doctorlabel = new Label(addoctor, SWT.NONE);
		FormData fd_doctorlabel = new FormData();
		fd_doctorlabel.top = new FormAttachment(50);
		fd_doctorlabel.left = new FormAttachment(45);
		doctorlabel.setLayoutData(fd_doctorlabel);
		doctorlabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		doctorlabel.setText("\u533B\u751F");
		subject.add("Éñ¾­ÄÚ¿Æ", 0);
		subject.add("ºôÎü¿Æ", 1);
		subject.add("ÃÚÄò¿Æ", 2);
		subject.add("·ÅÉä¿Æ", 3);
		subject.add("Îå¹Ù", 4);
		
		doctornametext = new Text(addoctor, SWT.BORDER);
		doctornametext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FormData fd_doctornametext = new FormData();
		fd_doctornametext.top = new FormAttachment(50);
		fd_doctornametext.left = new FormAttachment(50);
		doctornametext.setLayoutData(fd_doctornametext);
		doctornametext.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		
		Label label = new Label(addoctor, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(40);
		fd_label.left = new FormAttachment(45);
		label.setLayoutData(fd_label);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		label.setText("\u8BF7\u8F93\u5165\u5C06\u8981\u6DFB\u52A0\u533B\u751F\u7684\u59D3\u540D");
		
		Label label_1 = new Label(addoctor, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.top = new FormAttachment(20);
		fd_label_1.left = new FormAttachment(45);
		label_1.setLayoutData(fd_label_1);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		label_1.setText("\u8BF7\u9009\u62E9\u8981\u6DFB\u52A0\u7684\u79D1\u5BA4");
		
		Button addbutton = new Button(addoctor, SWT.NONE);
		FormData fd_addbutton = new FormData();
		fd_addbutton.top = new FormAttachment(60);
		fd_addbutton.left = new FormAttachment(45);
		addbutton.setLayoutData(fd_addbutton);
		buttonSelectionListener bsl = new buttonSelectionListener(doctornametext,pdtableimpl,subject,addoctor);
		addbutton.addSelectionListener(bsl);
		/*addbutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PDtableDAOImpl pdtableimpl = new PDtableDAOImpl();
				String subject = 
				doctorname = doctornametext.getText();
				pdtableimpl.Save(subject, doctorname);
			}
		});*/
		addbutton.setFont(SWTResourceManager.getFont("¿¬Ìå", 14, SWT.BOLD));
		addbutton.setText("\u786E\u8BA4\u6DFB\u52A0");
		
		Button returnButton = new Button(addoctor, SWT.NONE);
		returnButton.setText("\u8FD4\u56DE");
		returnButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 14, SWT.BOLD));
		FormData fd_returnButton = new FormData();
		fd_returnButton.top = new FormAttachment(60);
		fd_returnButton.left = new FormAttachment(53);
		returnButton.setLayoutData(fd_returnButton);
		btnNewSelecter2 bs = new btnNewSelecter2(window03,addoctor);
		returnButton.addSelectionListener(bs);	
	}
}
class buttonSelectionListener extends SelectionAdapter{
	Text doctorname;
	PDtableDAOImpl pdtableimpl;
	Combo subject;
	Shell shell;
	buttonSelectionListener(Text doctorname,PDtableDAOImpl pdtableimpl,Combo subject,Shell shell){
		this.doctorname = doctorname;
		this.pdtableimpl = pdtableimpl;
		this.subject = subject;
		this.shell = shell;
	}
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		String Subject = subject.getText();
		String Doctorname = doctorname.getText();
		pdtableimpl.Save(Subject, Doctorname);
		MessageBox messagebox = new MessageBox(shell);
		messagebox.setMessage("Ìí¼Ó³É¹¦£¡");
		messagebox.open();	
	}
	
}
class ControlLister implements org.eclipse.swt.events.ControlListener{
	FormData fd;
	int x;
	int y;
	public ControlLister(FormData fd,int x, int y){
		this.fd = fd;
		this.x = x;
		this.y = y;
	}
	public void controlMoved(ControlEvent arg0) {
		// TODO Auto-generated method stub	
	}
	public void controlResized(ControlEvent arg0) {
		// TODO Auto-generated method stub
		fd.left = new FormAttachment(x);
		fd.top =  new FormAttachment(y);
	}
}
class btnNewSelecter2 extends SelectionAdapter{
	Managermainpage window;
	Shell oldshell;
	public btnNewSelecter2(Managermainpage window,Shell oldshell){
		this.window = window;
		this.oldshell = oldshell;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		oldshell.dispose();
		window.open();
	}
}