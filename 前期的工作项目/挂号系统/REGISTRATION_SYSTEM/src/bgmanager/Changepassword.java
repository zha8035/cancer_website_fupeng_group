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

public class Changepassword {

	protected Shell shln;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Changepassword window = new Changepassword();
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
		shln.open();
		shln.layout();
		while (!shln.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shln = new Shell();
		managerload m2 = new managerload();
		shln.setSize(476, 339);
		shln.setText("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");
		shln.setLayout(null);
		
		Label lblNewLabel = new Label(shln, SWT.NONE);
		lblNewLabel.setBounds(108, 79, 104, 27);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel.setText("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		
		text = new Text(shln, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text.setBounds(218, 80, 115, 23);
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text.setEchoChar('*');
		
		Label lblNewLabel_1 = new Label(shln, SWT.NONE);
		lblNewLabel_1.setBounds(108, 125, 104, 27);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_1.setText("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		
		text_1 = new Text(shln, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_1.setBounds(218, 126, 115, 23);
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text_1.setEchoChar('*');
		
		Label lblNewLabel_2 = new Label(shln, SWT.NONE);
		lblNewLabel_2.setBounds(108, 170, 104, 27);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_2.setText("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		
		text_2 = new Text(shln, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_2.setBounds(218, 164, 115, 23);
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text_2.setEchoChar('*');
		
		Button changeButton = new Button(shln, SWT.NONE);
		changeButton.setBounds(119, 228, 93, 27);
		changeButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 16, SWT.BOLD));
		changeButton.setText("\u786E\u8BA4\u4FEE\u6539");
		chSelection cp = new chSelection(text,text_1,text_2,shln,m2);
		changeButton.addSelectionListener(cp);
		
		Button returnButton_1 = new Button(shln, SWT.NONE);
		returnButton_1.setBounds(275, 228, 58, 27);
		returnButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				managerload Window = new managerload();
				shln.dispose();
				Window.open();
			}
		});
		returnButton_1.setFont(SWTResourceManager.getFont("¿¬Ìå", 16, SWT.BOLD));
		returnButton_1.setText("\u8FD4\u56DE");
		
		Label lblNewLabel_3 = new Label(shln, SWT.NONE);
		lblNewLabel_3.setBounds(151, 25, 175, 24);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("¿¬Ìå", 18, SWT.BOLD));
		lblNewLabel_3.setText("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");

	}

}
class chSelection extends SelectionAdapter{
	Text text,text_1,text_2;
	managerload m2;
	Shell shell;
	chSelection(Text text,Text text_1,Text text_2,Shell shln,managerload m2){
		this.text = text;
		this.text_1 = text_1;
		this.text_2 = text_2;
		shell = shln;
		this.m2 = m2;
	}
	public void widgetSelected(SelectionEvent e) {
		bgmanagerdaoimpl bgdi = new bgmanagerdaoimpl();
		String s = bgdi.findBypassword();
		if(s.equals(text.getText())){
			bgdi.changepassword(text_1.getText());
		}
		MessageBox messagebox = new MessageBox(shell);
		messagebox.setMessage("ÐÞ¸Ä³É¹¦£¡");
		messagebox.open();
		shell.dispose();
		m2.open();
	}
}