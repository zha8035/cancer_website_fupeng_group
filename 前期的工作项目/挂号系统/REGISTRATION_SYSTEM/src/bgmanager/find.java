package bgmanager;

import load.RegisterDAOImpl;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class find {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			find window = new find();
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
		shell.setSize(450, 300);
		shell.setText("\u4EBA\u6570\u67E5\u8BE2");
		RegisterDAOImpl RD = new RegisterDAOImpl();
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel.setBounds(57, 21, 120, 26);
		lblNewLabel.setText("\u5F53\u65E5\u6302\u53F7\u603B\u4EBA\u6570");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text.setBounds(183, 21, 89, 23);
		Button btnNewButton = new Button(shell, SWT.NONE);
/*		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RD.find2();
			}
		});*/
		btnNewButton.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		btnNewButton.setBounds(302, 18, 80, 27);
		btnNewButton.setText("\u67E5\u8BE2");
		Find1 find1 = new  Find1 (RD,text) ;
		btnNewButton.addSelectionListener(find1);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(57, 68, 112, 26);
		lblNewLabel_1.setText("\u5404\u79D1\u5BA4\u6302\u53F7\u60C5\u51B5");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		combo.setBounds(184, 65, 88, 25);
		combo.setText("\u9009\u62E9\u79D1\u5BA4");
		combo.add("Éñ¾­ÄÚ¿Æ", 0);
		combo.add("ºôÎü¿Æ", 1);
		combo.add("ÃÚÄò¿Æ", 2);
		combo.add("·ÅÉä¿Æ", 3);
		combo.add("Îå¹Ù", 4);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(88, 155, 89, 23);
		lblNewLabel_2.setText("\u5404\u533B\u751F\u60C5\u51B5");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text_1.setBounds(183, 156, 89, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text_2.setBounds(183, 204, 89, 23);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text_3.setBounds(183, 106, 89, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("\u67E5\u8BE2");
		button.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		button.setBounds(302, 102, 80, 27);
		Find2 find2 = new Find2(RD,text_3,combo);
		button.addSelectionListener(find2);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("\u67E5\u8BE2");
		button_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		button_1.setBounds(302, 204, 80, 27);
		Find3 find3 = new Find3(RD,text_1,text_2);
		button_1.addSelectionListener(find3);
		
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 8, SWT.NORMAL));
		lblNewLabel_3.setBounds(278, 161, 156, 17);
		lblNewLabel_3.setText("\uFF08\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u533B\u751F\u7684\u59D3\u540D\uFF09");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Managermainpage managermain = new Managermainpage();
				shell.dispose();
				managermain.open();
			}
		});
		button_2.setText("\u8FD4\u56DE");
		button_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		button_2.setBounds(10, 225, 80, 27);

	}
}
class Find1 extends SelectionAdapter{
	RegisterDAOImpl RD;
	Text text;
	public Find1(RegisterDAOImpl RD,Text text){
		this.RD = RD;
		this.text = text;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		text.setText(RD.find2()+"ÈË");
	}
}

class Find2 extends SelectionAdapter{
	RegisterDAOImpl RD2;
	Text text;
	Combo combo;
	public Find2(RegisterDAOImpl RD2,Text text,Combo combo){
		this.RD2 = RD2;
		this.text = text;
		this.combo = combo;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		int j = combo.getSelectionIndex();
		text.setText(RD2.find3(combo.getItem(j))+"ÈË");
	}
}

class Find3 extends SelectionAdapter{
	RegisterDAOImpl RD3;
	Text text1,text2;
	Combo combo;
	public Find3(RegisterDAOImpl RD3,Text text1,Text text2){
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
