package register;

import load.Load;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

import patient.PatientInfo;
import patientDAOImpl.PatientDAOImpl;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class Register {

	protected Shell register;
	private Text nametext;
	private Text agetext;
	private Text IDcardtext;
	private Text placetext;
	private Text subjecttext;
	private Text doctortext;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Register window02 = new Register();
			window02.open();
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
		register.open();
		register.layout();
		while (!register.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		final PatientInfo patientinfo = new PatientInfo();
		register = new Shell();
		register.setSize(new Point(978, 600));
		register.setSize(611, 368);
		register.setLayout(new FormLayout());
		Load window02 = new Load();
		
		Label name = new Label(register, SWT.NONE);
		FormData fd_name = new FormData();
		fd_name.bottom = new FormAttachment(0, 90);
		fd_name.right = new FormAttachment(0, 226);
		fd_name.top = new FormAttachment(0, 67);
		fd_name.left = new FormAttachment(0, 195);
		name.setLayoutData(fd_name);
		name.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		name.setText("\u59D3\u540D");
		
		Label age = new Label(register, SWT.NONE);
		FormData fd_age = new FormData();
		fd_age.bottom = new FormAttachment(0, 124);
		fd_age.right = new FormAttachment(0, 226);
		fd_age.top = new FormAttachment(0, 104);
		fd_age.left = new FormAttachment(0, 195);
		age.setLayoutData(fd_age);
		age.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		age.setText("\u5E74\u9F84");
		
		Label title = new Label(register, SWT.NONE);
		FormData fd_title = new FormData();
		fd_title.bottom = new FormAttachment(0, 48);
		fd_title.right = new FormAttachment(0, 370);
		fd_title.top = new FormAttachment(0, 25);
		fd_title.left = new FormAttachment(0, 246);
		title.setLayoutData(fd_title);
		title.setFont(SWTResourceManager.getFont("楷体", 16, SWT.BOLD));
		title.setAlignment(SWT.CENTER);
		title.setText("\u75C5\u4EBA\u6CE8\u518C");
		
		nametext = new Text(register, SWT.BORDER);
		FormData fd_nametext = new FormData();
		fd_nametext.top = new FormAttachment(name, 1, SWT.TOP);
		fd_nametext.left = new FormAttachment(0, 246);
		nametext.setLayoutData(fd_nametext);
		
		agetext = new Text(register, SWT.BORDER);
		agetext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				char str[] = agetext.getText().toCharArray();
				int i = str.length;
				for (int j=0; j<i; j++){
					if(!(Character.isDigit(str[j]))){
						MessageBox messagebox = new MessageBox(register);
						messagebox.setMessage("您输入了非法字符，年龄必须是整数，请重新输入！");
						messagebox.open();
					}
				}
			}
		});
		FormData fd_agetext = new FormData();
		fd_agetext.right = new FormAttachment(0, 288);
		fd_agetext.top = new FormAttachment(0, 101);
		fd_agetext.left = new FormAttachment(0, 246);
		agetext.setLayoutData(fd_agetext);
		agetext.setTextLimit(2);
		
		Label sex = new Label(register, SWT.NONE);
		FormData fd_sex = new FormData();
		fd_sex.bottom = new FormAttachment(0, 161);
		fd_sex.right = new FormAttachment(0, 226);
		fd_sex.top = new FormAttachment(0, 134);
		fd_sex.left = new FormAttachment(0, 195);
		sex.setLayoutData(fd_sex);
		sex.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		sex.setText("\u6027\u522B");
		
		final Button man = new Button(register, SWT.RADIO);
		man.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		FormData fd_man = new FormData();
		fd_man.left = new FormAttachment(sex, 38);
		fd_man.top = new FormAttachment(sex, 4, SWT.TOP);
		man.setLayoutData(fd_man);
		man.setText("\u7537");
		
		final Button feman = new Button(register, SWT.RADIO);
		fd_nametext.right = new FormAttachment(feman, 0, SWT.RIGHT);
		fd_man.right = new FormAttachment(100, -289);
		FormData fd_feman = new FormData();
		fd_feman.right = new FormAttachment(100, -237);
		fd_feman.top = new FormAttachment(sex, 4, SWT.TOP);
		feman.setLayoutData(fd_feman);
		feman.setText("\u5973");
		
		Button registerButton = new Button(register, SWT.NONE);
		FormData fd_registerButton = new FormData();
		fd_registerButton.bottom = new FormAttachment(100);
		registerButton.setLayoutData(fd_registerButton);
		registerButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
						// TODO Auto-generated method stub		
				if(nametext.getText() == null){
					MessageBox messagebox = new MessageBox(register);
					messagebox.setMessage("用户名不能为空");
					messagebox.open();
				}
				int age = Integer.parseInt(agetext.getText());
				if(age <= 20 || age >= 100){
					MessageBox messagebox = new MessageBox(register);
				    messagebox.setMessage("您输入的年龄超出范围，年龄必须是20—99之间的数字，请重新输入！");
					messagebox.open();
					}			
				patientinfo.setName(nametext.getText());
				patientinfo.setAge(Integer.parseInt(agetext.getText()));
				patientinfo.setIdcard(IDcardtext.getText());
				if(man.getSelection())
					patientinfo.setSex(man.getText());
				else 
					patientinfo.setSex(feman.getText());
				patientinfo.setAddress(placetext.getText());
				patientinfo.setSubject(subjecttext.getText());
				patientinfo.setDoctor(doctortext.getText());
				PatientDAOImpl patientdaoimpl = new PatientDAOImpl();
				patientdaoimpl.Save(patientinfo);
				Load load = new Load();
				register.dispose();
				load.open();
			}
		});
		registerButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		registerButton.setText("\u6CE8\u518C");
		
		Label IDcard = new Label(register, SWT.NONE);
		FormData fd_IDcard = new FormData();
		fd_IDcard.bottom = new FormAttachment(0, 190);
		fd_IDcard.right = new FormAttachment(0, 226);
		fd_IDcard.top = new FormAttachment(0, 167);
		fd_IDcard.left = new FormAttachment(0, 165);
		IDcard.setLayoutData(fd_IDcard);
		IDcard.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		IDcard.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		
		IDcardtext = new Text(register, SWT.BORDER);
		FormData fd_IDcardtext = new FormData();
		fd_IDcardtext.right = new FormAttachment(0, 397);
		fd_IDcardtext.top = new FormAttachment(0, 167);
		fd_IDcardtext.left = new FormAttachment(0, 246);
		IDcardtext.setLayoutData(fd_IDcardtext);
		IDcardtext.setBackground(SWTResourceManager.getColor(255, 255, 255));
		IDcardtext.setForeground(SWTResourceManager.getColor(0, 0, 0));
		IDcardtext.setTextLimit(18);
		
		Label place = new Label(register, SWT.NONE);
		fd_registerButton.right = new FormAttachment(place, 0, SWT.RIGHT);
		FormData fd_place = new FormData();
		fd_place.bottom = new FormAttachment(0, 228);
		fd_place.right = new FormAttachment(0, 234);
		fd_place.top = new FormAttachment(0, 205);
		fd_place.left = new FormAttachment(0, 165);
		place.setLayoutData(fd_place);
		place.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		place.setText("\u5BB6\u5EAD\u4F4F\u5740");
		
		placetext = new Text(register, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_placetext = new FormData();
		fd_placetext.right = new FormAttachment(0, 397);
		fd_placetext.top = new FormAttachment(0, 205);
		fd_placetext.left = new FormAttachment(0, 246);
		placetext.setLayoutData(fd_placetext);
		
		Label subject = new Label(register, SWT.NONE);
		FormData fd_subject = new FormData();
		fd_subject.bottom = new FormAttachment(0, 263);
		fd_subject.right = new FormAttachment(0, 237);
		fd_subject.top = new FormAttachment(0, 240);
		fd_subject.left = new FormAttachment(0, 195);
		subject.setLayoutData(fd_subject);
		subject.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		subject.setText("\u79D1\u5BA4");
		
		subjecttext = new Text(register, SWT.BORDER);
		FormData fd_subjecttext = new FormData();
		fd_subjecttext.right = new FormAttachment(0, 397);
		fd_subjecttext.top = new FormAttachment(0, 240);
		fd_subjecttext.left = new FormAttachment(0, 246);
		subjecttext.setLayoutData(fd_subjecttext);
		subjecttext.setForeground(SWTResourceManager.getColor(0, 0, 0));
		subjecttext.setBackground(SWTResourceManager.getColor(255, 255, 255));
		
		Label label = new Label(register, SWT.NONE);
		fd_registerButton.top = new FormAttachment(0, 307);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(subject, 15);
		fd_label.bottom = new FormAttachment(registerButton, -6);
		fd_label.left = new FormAttachment(IDcard, 0, SWT.LEFT);
		fd_label.right = new FormAttachment(registerButton, 0, SWT.RIGHT);
		label.setLayoutData(fd_label);
		label.setText("\u4E3B\u6CBB\u533B\u751F");
		
		doctortext = new Text(register, SWT.BORDER);
		FormData fd_doctortext = new FormData();
		fd_doctortext.top = new FormAttachment(subjecttext, 14);
		fd_doctortext.left = new FormAttachment(title, 0, SWT.LEFT);
		doctortext.setLayoutData(fd_doctortext);
		
		Button returnButton = new Button(register, SWT.NONE);
		returnListener rl = new returnListener(window02,register);
		returnButton.addSelectionListener(rl);

		FormData fd_returnButton = new FormData();
		fd_returnButton.right = new FormAttachment(IDcardtext, 1, SWT.RIGHT);
		fd_returnButton.left = new FormAttachment(registerButton, 118);
		fd_returnButton.top = new FormAttachment(label, 25, SWT.TOP);
		fd_returnButton.bottom = new FormAttachment(100);
		returnButton.setLayoutData(fd_returnButton);
		returnButton.setText("\u8FD4\u56DE");

	}
}
class returnListener extends SelectionAdapter{
	Load window02 = new Load();
	Shell oldshell;
	public returnListener(Load window, Shell shell){
		window02 = window;
		oldshell = shell; 
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		oldshell.dispose();
		window02.open();
	}
	
	
}