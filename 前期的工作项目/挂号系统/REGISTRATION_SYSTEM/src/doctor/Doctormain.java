package doctor;

import load.RegisterDAOImpl;
import load.register;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Doctormain {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text doctortext;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Doctormain window = new Doctormain();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(484, 343);
		shell.setText("SWT Application");
		shell.setLayout(null);
/*		RegisterDAOImpl RD = new RegisterDAOImpl();*/
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 69, 26);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label.setText("\u5F85\u8BCA\u75C5\u4EBA");
		
		final List list = new List(shell, SWT.BORDER);
		list.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		list.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		list.setBounds(10, 42, 69, 101);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel.setBounds(10, 161, 69, 26);
		lblNewLabel.setText("\u5DF2\u8BCA\u75C5\u4EBA");
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		list_1.setBounds(8, 193, 71, 92);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.NONE);
		mntmFile.setText("File");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text.setBounds(84, 13, 27, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_1.setBounds(85, 164, 27, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_1.setText("\u59D3\u540D");
		label_1.setBounds(151, 33, 39, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_2.setBounds(196, 34, 90, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(151, 102, 32, 19);
		lblNewLabel_1.setText("\u5E74\u9F84");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_3.setBounds(196, 103, 90, 23);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(117, 0, 2, 298);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_3.setBounds(151, 73, 39, 23);
		label_3.setText("\u6027\u522B");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_4.setBounds(196, 73, 90, 23);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_5.setBounds(196, 138, 262, 117);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_4.setBounds(163, 137, 27, 26);
		label_4.setText("\u75C5");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_5.setBounds(163, 171, 27, 22);
		label_5.setText("\u60C5");
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_6.setBounds(163, 203, 21, 23);
		label_6.setText("\u5206");
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_7.setBounds(163, 232, 21, 23);
		label_7.setText("\u6790");
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_6.setBounds(302, 55, 156, 68);
		
		doctortext = new Text(shell, SWT.BORDER);
		doctortext.setBounds(376, 11, 73, 23);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(349, 33, 76, 19);
		lblNewLabel_2.setText("\u75C5\u51B5\u7B80\u4ECB");
		
		Button nextone = new Button(shell, SWT.NONE);
		nextone.setBounds(345, 258, 80, 27);
		nextone.setText("\u4E0B\u4E00\u4F4D");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_3.setBounds(221, 10, 69, 26);
		lblNewLabel_3.setText("\u6B63\u5728\u8BCA\u65AD");
		
		Button startbutton = new Button(shell, SWT.NONE);
		startbutton.addSelectionListener(new SelectionAdapter() {
			RegisterDAOImpl RD = new RegisterDAOImpl();
			String r;
			int i = 0;
			@Override
			public void widgetSelected(SelectionEvent e) {
				r = RD.find6bydoctor(doctortext.getText());
				while(r != null){
					list.add(r,i);
					i++;
				}
				text.setText(i+"ÈË");
			}
		});
		startbutton.setText("\u51C6\u5907\u5C31\u8BCA");
		startbutton.setBounds(196, 261, 80, 27);
/*		Findpatient1 find1 = new  Findpatient1 (RD,text) ;*/
		
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_4.setBounds(301, 10, 69, 26);
		lblNewLabel_4.setText("\u5F53\u524D\u533B\u751F");
		
/*		startbutton.addSelectionListener(find1);*/

	}
}
class Findpatient1 extends SelectionAdapter{
	RegisterDAOImpl RD3;
	Text text1,text2;
	Combo combo;
	public Findpatient1(RegisterDAOImpl RD3,Text text1,Text text2){
		this.RD3 = RD3;
		this.text1 = text1;
		this.text2 = text2;;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		text2.setText(RD3.find4(text1.getText())+"ÈË");
	}
}