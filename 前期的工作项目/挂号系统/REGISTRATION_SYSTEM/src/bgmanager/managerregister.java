package bgmanager;

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

import bgmanagerDAOImpl.bgmanagerdaoimpl;

public class managerregister {

	protected Shell name;
	private Text nametext;
	private Text sextext;
	private Text passwordtext;
	private Text pwpasswordtext;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			managerregister window = new managerregister();
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
		name.open();
		name.layout();
		while (!name.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		managerload ml = new managerload();
		name = new Shell();
		name.setSize(483, 334);
		name.setText("SWT Application");
		
		Label label = new Label(name, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("¿¬Ìå", 16, SWT.NORMAL));
		label.setBounds(189, 20, 110, 27);
		label.setText("\u7BA1\u7406\u5458\u6CE8\u518C");
		
		Label namelabel = new Label(name, SWT.NONE);
		namelabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		namelabel.setBounds(163, 57, 39, 23);
		namelabel.setText("\u59D3\u540D");
		
		nametext = new Text(name, SWT.BORDER);
		nametext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		nametext.setBounds(224, 58, 89, 23);
		
		Label sexlabel = new Label(name, SWT.NONE);
		sexlabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		sexlabel.setBounds(163, 95, 39, 20);
		sexlabel.setText("\u6027\u522B");
		
		sextext = new Text(name, SWT.BORDER);
		sextext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		sextext.setBounds(224, 96, 89, 23);
		
		Label passwordlabel = new Label(name, SWT.NONE);
		passwordlabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		passwordlabel.setBounds(163, 139, 39, 20);
		passwordlabel.setText("\u5BC6\u7801");
		
		passwordtext = new Text(name, SWT.BORDER);
		passwordtext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		passwordtext.setBounds(224, 140, 89, 23);
		passwordtext.setEchoChar('*');
		
		Label pwpasswordlabel = new Label(name, SWT.NONE);
		pwpasswordlabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		pwpasswordlabel.setBounds(129, 179, 73, 23);
		pwpasswordlabel.setText("\u786E\u8BA4\u5BC6\u7801");
		
		pwpasswordtext = new Text(name, SWT.BORDER);
		pwpasswordtext.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		pwpasswordtext.setBounds(224, 180, 89, 23);
		pwpasswordtext.setEchoChar('*');
		
		Button registerButton = new Button(name, SWT.NONE);
		registerButton.setText("\u6CE8\u518C");
		registerButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 14, SWT.NORMAL));
		registerButton.setBounds(141, 225, 61, 27);
		registerbuttonListener rbl = new registerbuttonListener(nametext,sextext,passwordtext,pwpasswordtext,name,ml);
		registerButton.addSelectionListener(rbl);
		
		Button exitButton = new Button(name, SWT.NONE);
		exitButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				managerload window1 = new managerload();
				name.dispose();
				window1.open();
			}
		});
		exitButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 14, SWT.NORMAL));
		exitButton.setBounds(286, 225, 61, 27);
		exitButton.setText("\u8FD4\u56DE");

	}

}
class registerbuttonListener extends SelectionAdapter{
	Text nametext,sextext,passwordtext,pwpasswordtext;
	Shell name;
	managerload ml;
	registerbuttonListener(Text nametext,Text sextext,Text passwordtext,Text pwpasswordtext,Shell name,managerload ml){
		this.nametext = nametext;
		this.sextext = sextext;
		this.passwordtext = passwordtext;
		this.pwpasswordtext = passwordtext;
		this.ml = ml;
		this.name = name;
		
	}
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		BGM bgm = new BGM();
		bgm.setName(nametext.getText());
		bgm.setSex(sextext.getText());
		bgm.setPassword(passwordtext.getText());
		bgm.setPwpassword(pwpasswordtext.getText());
		bgmanagerdaoimpl bgdi = new bgmanagerdaoimpl();
		bgdi.save(bgm);
		MessageBox messagebox = new MessageBox(name);
		messagebox.setMessage("×¢²á³É¹¦£¡");
		messagebox.open();	
		name.dispose();
		ml.open();
	}
}
