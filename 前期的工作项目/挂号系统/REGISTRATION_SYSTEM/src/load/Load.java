package load;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import register.Register;
import org.eclipse.swt.widgets.Combo;

import patient.PatientInfo;
import patientDAOImpl.PatientDAOImpl;
import pdtable.PDtable;
import pdtableDAOImpl.PDtableDAOImpl;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class Load {

	PDtableDAOImpl pdtabledaoimpl = new PDtableDAOImpl();
	PDtable pdtable = new PDtable();
	register Register = new register();
	RegisterDAOImpl registerdaoimpl = new RegisterDAOImpl();
	int m =0 ;
	protected Shell load;
	private Text nametext;
	private Text costtext;
	private static int[] i = new int[1];

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Load window01 = new Load();
			window01.open();
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
		load.open();
		load.layout();
		while (!load.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		register Register = new register();
		RegisterDAOImpl RDI = new RegisterDAOImpl();	
		
		load = new Shell();
		load.setSize(519, 370);
		load.setText("XX\u533B\u9662\u6302\u53F7\u7CFB\u7EDF");
		load.setLayout(new FormLayout());
		
		Label name = new Label(load, SWT.NONE);
		FormData fd_name = new FormData();
		fd_name.top = new FormAttachment(20);
		fd_name.left = new FormAttachment(45, -10);
		name.setLayoutData(fd_name);
		name.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		name.setText("\u59D3\u540D");
		
		Label subjet = new Label(load, SWT.NONE);
		FormData fd_subjet = new FormData();
		fd_subjet.left = new FormAttachment(44);
		fd_subjet.top = new FormAttachment(50);
		subjet.setLayoutData(fd_subjet);
		subjet.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		subjet.setText("\u79D1\u5BA4");
		
		Label doctor = new Label(load, SWT.NONE);
		FormData fd_doctor = new FormData();
		fd_doctor.top = new FormAttachment(60);
		fd_doctor.left = new FormAttachment(45, -10);
		doctor.setLayoutData(fd_doctor);
		doctor.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		doctor.setText("\u533B\u751F");
		
		nametext = new Text(load, SWT.BORDER);
		nametext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		nametext.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		FormData fd_nametext = new FormData();
		fd_nametext.right = new FormAttachment(50, 94);
		fd_nametext.top = new FormAttachment(20);
		fd_nametext.left = new FormAttachment(50);
		nametext.setLayoutData(fd_nametext);
		
		Label titlelabel = new Label(load, SWT.NONE);
		FormData fd_titlelabel = new FormData();
		fd_titlelabel.right = new FormAttachment(43, 176);
		fd_titlelabel.top = new FormAttachment(10);
		fd_titlelabel.left = new FormAttachment(43);
		titlelabel.setLayoutData(fd_titlelabel);
		titlelabel.setFont(SWTResourceManager.getFont("楷体", 18, SWT.BOLD));
		titlelabel.setText("XX\u533B\u9662\u95E8\u8BCA\u6302\u53F7");
		
		Label label = new Label(load, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(40);
		fd_label.left = new FormAttachment(44, -10);
		label.setLayoutData(fd_label);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		label.setText("\u6302\u53F7\u8D39");
		
		costtext = new Text(load, SWT.BORDER);
		costtext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		costtext.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		FormData fd_costtext = new FormData();
		fd_costtext.right = new FormAttachment(nametext, 0, SWT.RIGHT);
		fd_costtext.top = new FormAttachment(40);
		fd_costtext.left = new FormAttachment(50);
		costtext.setLayoutData(fd_costtext);
		
		Label type = new Label(load, SWT.NONE);
		FormData fd_type = new FormData();
		fd_type.top = new FormAttachment(30);
		fd_type.left = new FormAttachment(45, -10);
		type.setLayoutData(fd_type);
		type.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		type.setText("\u7C7B\u578B");
		
		Combo typecombo = new Combo(load, SWT.NONE);
		typecombo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		typecombo.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		FormData fd_typecombo = new FormData();
		fd_typecombo.right = new FormAttachment(nametext, 0, SWT.RIGHT);
		fd_typecombo.top = new FormAttachment(30);
		fd_typecombo.left = new FormAttachment(50);
		typecombo.setLayoutData(fd_typecombo);
		typecombo.setText("\u95E8\u8BCA\u7C7B\u578B");
		typecombo.add("普通门诊",0);
		typecombo.add("专家门诊",1);
		MySelectionListener3 ms3 = new MySelectionListener3(typecombo,costtext);
		typecombo.addSelectionListener(ms3);
		
		Combo doctorcombo = new Combo(load, SWT.NONE);
		doctorcombo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		doctorcombo.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		FormData fd_doctorcombo = new FormData();
		fd_doctorcombo.right = new FormAttachment(nametext, 0, SWT.RIGHT);
		fd_doctorcombo.top = new FormAttachment(60);
		fd_doctorcombo.left = new FormAttachment(50);
		doctorcombo.setLayoutData(fd_doctorcombo);
		doctorcombo.setText("\u9009\u62E9\u533B\u751F");
		
		Combo subject = new Combo(load, SWT.NONE);
		subject.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		subject.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		fd_subjet.right = new FormAttachment(subject, -6);
		fd_subjet.top = new FormAttachment(subject, -1, SWT.TOP);
		FormData fd_subject = new FormData();
		fd_subject.right = new FormAttachment(nametext, 0, SWT.RIGHT);
		fd_subject.top = new FormAttachment(50);
		fd_subject.left = new FormAttachment(50);
		subject.setLayoutData(fd_subject);
		subject.setText("\u79D1\u5BA4\uFF1F");
		subject.add("神经内科", 0);
		subject.add("呼吸科", 1);
		subject.add("泌尿科", 2);
		subject.add("放射科", 3);
		subject.add("五官", 4);
		MySelectionListener myselection = new MySelectionListener(i,subject,doctorcombo,pdtabledaoimpl);
		subject.addSelectionListener(myselection);
		
		MySelectionListener2 ms2 = new MySelectionListener2(subject,doctorcombo,Register,nametext,RDI);
		doctorcombo.addSelectionListener(ms2);
		
		Button surebutton = new Button(load, SWT.NONE);
		FormData fd_surebutton = new FormData();
		fd_surebutton.top = new FormAttachment(70);
		fd_surebutton.left = new FormAttachment(44);
		surebutton.setLayoutData(fd_surebutton);
		surebutton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		surebutton.setText("\u786E\u5B9A");
		surebutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
     	        Register register = new Register();
				PatientDAOImpl patientdaoimpl = new PatientDAOImpl();

/*				registerdaoimpl.Save(Register);*/
				PatientInfo patientinfo = null;
				patientinfo = patientdaoimpl.findByname(nametext.getText());
				if(patientinfo.getId() > 0 ){
					MessageBox messagebox = new MessageBox(load);
					messagebox.setMessage("挂号成功！");
					messagebox.open();
				}
				else{
					MessageBox messagebox = new MessageBox(load);
					messagebox.setMessage("此用户不存在，请先注册");
					messagebox.open();
					load.dispose();
					register.open();
				}
			}
		});
		
		Button registerbutton = new Button(load, SWT.NONE);
		FormData fd_registerbutton = new FormData();
		fd_registerbutton.top = new FormAttachment(70);
		fd_registerbutton.left = new FormAttachment(53);
		registerbutton.setLayoutData(fd_registerbutton);
		registerbutton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		registerbutton.setText("\u6CE8\u518C");
		registerbutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {	
				Register register = new Register();
				load.close();
				register.open();
			}
		});
	}
}

//定义外部类作为独立监听器
class MySelectionListener extends SelectionAdapter{
	
	int i[] = new int[1];
	Combo subject = null;
	Combo doctorcombo = null ;
	PDtableDAOImpl pdtabledaoimpl = null;
	register Register = null;
	RegisterDAOImpl registerdaoimpl = null;

    MySelectionListener(int[] a,Combo subject,Combo doctorcombo,PDtableDAOImpl pdtabledaoimpl){
    	this.i = a;
    	this.subject = subject;
    	this.doctorcombo = doctorcombo;
    	this.pdtabledaoimpl = pdtabledaoimpl;
    }
    
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub	    	
		doctorcombo.removeAll();
		int i = subject.getSelectionIndex();
		 if(i == 0){
				int j = pdtabledaoimpl.findByname1(subject.getItem(0));
				for (int k = 0; k < j; k++){
					String ss = pdtabledaoimpl.findByname2(subject.getItem(0),j,k);
					doctorcombo.add(ss, k);
				}		
			}
		 else if(i == 1){
				int j = pdtabledaoimpl.findByname1(subject.getItem(1));
				for (int k = 0; k < j; k++){
					String ss = pdtabledaoimpl.findByname2(subject.getItem(1),j,k);
					doctorcombo.add(ss, k);
				}		
			}
		 else if(i == 2){
				int j = pdtabledaoimpl.findByname1(subject.getItem(2));
				for(int k = 0; k< j; k++){
					String ss = pdtabledaoimpl.findByname2(subject.getItem(2),j,k);
					doctorcombo.add(ss, k);
				}
			}
		 else if(i == 3){
				int j = pdtabledaoimpl.findByname1(subject.getItem(3));
				for(int k = 0; k< j; k++){
					String ss = pdtabledaoimpl.findByname2(subject.getItem(3),j,k);
					doctorcombo.add(ss, k);
				}
			}
		 else if(i == 4){
				int j = pdtabledaoimpl.findByname1(subject.getItem(4));
				for(int k = 0; k< j; k++){
					String ss = pdtabledaoimpl.findByname2(subject.getItem(4),j,k);
					doctorcombo.add(ss, k);
					}
				}
		}
}
class MySelectionListener2 extends SelectionAdapter{
	Combo subject ;
	Combo doctorcombo ;
	register Register;
	RegisterDAOImpl RDI;
	Text nametext;
	public MySelectionListener2(Combo subject, Combo doctorcombo,register Register,Text nametext,RegisterDAOImpl RDI){
		this.subject = subject;
		this.doctorcombo = doctorcombo;
		this.RDI = RDI;
		this.Register = Register;
		this.nametext = nametext;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		int i = doctorcombo.getSelectionIndex();
		int j = subject.getSelectionIndex();
		Register.setName(nametext.getText());
		Register.setSubject(subject.getItem(j));
		Register.setDoctor(doctorcombo.getItem(i));
		RDI.Save(Register);
	}
}
class MySelectionListener3 extends SelectionAdapter{
	Combo typecombo ;
	Text costtext;
	public MySelectionListener3(Combo typecombo ,Text costtext){
		this.typecombo = typecombo;
		this.costtext = costtext; 
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		int i = typecombo.getSelectionIndex();
		if(i == 0){
			costtext.setText("3元");
		}
		else if(i == 1){
			costtext.setText("5元");
		}
	}
}
