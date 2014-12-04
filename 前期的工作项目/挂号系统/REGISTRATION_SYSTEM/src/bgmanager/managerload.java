package bgmanager;

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

import bgmanagerDAOImpl.bgmanagerdaoimpl;

public class managerload {

	protected Shell mload;
	private Text nametext;
	private Text passwordtext;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			managerload window = new managerload();
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
		mload.open();
		mload.layout();
		while (!mload.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		mload = new Shell();
		mload.setSize(450, 300);
		mload.setText("\u7BA1\u7406\u5458\u767B\u9646");
		Managermainpage Mm = new Managermainpage();
		managerload window1 = new managerload();
		
		Label managername = new Label(mload, SWT.NONE);
		managername.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.NORMAL));
		managername.setBounds(74, 53, 101, 21);
		managername.setText("\u7BA1\u7406\u5458\u8D26\u6237\u540D");
		
		nametext = new Text(mload, SWT.BORDER);
		nametext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		nametext.setBounds(185, 53, 95, 23);
		
		Label passwordlabel = new Label(mload, SWT.NONE);
		passwordlabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.NORMAL));
		passwordlabel.setBounds(134, 110, 41, 23);
		passwordlabel.setText("\u5BC6\u7801");
		
		passwordtext = new Text(mload, SWT.BORDER);
		passwordtext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		passwordtext.setBounds(185, 110, 95, 23);
		passwordtext.setEchoChar('*');
		
		Button load = new Button(mload, SWT.NONE);
		load.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.NORMAL));
		load.setBounds(115, 180, 60, 27);
		load.setText("\u767B\u9646");
		loadSelection lS = new loadSelection(nametext,passwordtext,Mm,mload,window1);
		load.addSelectionListener(lS);		
		Button exit = new Button(mload, SWT.NONE);
		exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mload.dispose();
			}
		});
		exit.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.NORMAL));
		exit.setBounds(218, 180, 60, 27);
		exit.setText("\u9000\u51FA");
		
		Button cpassword = new Button(mload, SWT.NONE);
		cpassword.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Changepassword Wi = new Changepassword();
				mload.dispose();
				Wi.open();
			}
		});
		cpassword.setBounds(303, 109, 60, 27);
		cpassword.setText("\u66F4\u6539\u5BC6\u7801");
		
		Button createaccount = new Button(mload, SWT.NONE);
		createaccount.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				managerregister wi = new managerregister();
				mload.dispose();
				wi.open();
			}
		});
		createaccount.setBounds(302, 53, 61, 27);
		createaccount.setText("\u521B\u5EFA\u8D26\u6237");

	}
}
class loadSelection extends SelectionAdapter{
	Text nametext;
	Text passwordtext;
	Managermainpage mp;
	managerload window;
	Shell shell;
	public loadSelection(Text name,Text password,Managermainpage window2,Shell shell,managerload window){
		nametext = name;
		passwordtext = password;
		mp = window2;
		this.window = window;
		this.shell = shell;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		bgmanagerdaoimpl bg = new bgmanagerdaoimpl();
		String p = bg.findByname(nametext.getText());
		if(p.equals(passwordtext.getText())){
			shell.dispose();
			mp.open();
		}
		else{
			MessageBox messagebox = new MessageBox(shell);
			messagebox.setMessage("”√ªß√˚”Î√‹¬Î≤ª∆•≈‰£¨«Î÷ÿ–¬ ‰»Î£°");
			messagebox.open();
			shell.dispose();
			window.open();		
		}
	}	
}