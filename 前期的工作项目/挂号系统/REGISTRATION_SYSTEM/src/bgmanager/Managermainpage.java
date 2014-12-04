package bgmanager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import doctor.DoctorDAOImpl;
import doctor.DoctorR;

public class Managermainpage {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Managermainpage window = new Managermainpage();
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
		shell.setSize(477, 340);
		shell.setText("\u540E\u53F0\u7BA1\u7406");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem systemmenuItem = new MenuItem(menu, SWT.CASCADE);
		systemmenuItem.setText("\u7CFB\u7EDF(S)");
		
		Menu menu_3 = new Menu(systemmenuItem);
		systemmenuItem.setMenu(menu_3);
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_3, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		mntmNewItem_1.setText("\u6CE8\u9500");
		
		MenuItem menuItem_2 = new MenuItem(menu_3, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Changepassword CP = new Changepassword();
				shell.dispose();
				CP.open();
			}
		});
		menuItem_2.setText("\u4FEE\u6539\u5BC6\u7801");
		
		MenuItem mntmNewRadiobutton = new MenuItem(menu, SWT.CASCADE);
		mntmNewRadiobutton.setText("\u95E8\u8BCA\u7BA1\u7406");
		
		Menu menu_4 = new Menu(mntmNewRadiobutton);
		mntmNewRadiobutton.setMenu(menu_4);
		
		Findpatient window3 = new Findpatient();
		MenuItem findpatient = new MenuItem(menu_4, SWT.NONE);
		findSelecter fs = new findSelecter(window3,shell);
		findpatient.addSelectionListener(fs);
/*		findpatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});*/
		findpatient.setText("\u75C5\u4EBA\u67E5\u8BE2");
		
		MenuItem mntmNewItem = new MenuItem(menu_4, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				find f = new find();
				shell.dispose();
				f.open();
			}
		});
		mntmNewItem.setText("\u6302\u53F7\u60C5\u51B5");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText("\u533B\u751F\u7BA1\u7406");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem add = new MenuItem(menu_2, SWT.NONE);
		add.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				BGManager BG = new BGManager();
				shell.dispose();
				BG.open();
			}
		});
		add.setText("\u6DFB\u52A0\u533B\u751F");
		
		MenuItem delete = new MenuItem(menu_2, SWT.NONE);
		delete.setText("\u5220\u9664\u533B\u751F");
		
		MenuItem rdoctorItem = new MenuItem(menu_2, SWT.NONE);
		rdoctorItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final DoctorDAOImpl ddi = new DoctorDAOImpl();
				final DoctorR dr = new DoctorR();
				Label lblNewLabel = new Label(shell, SWT.NONE);
				lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
				lblNewLabel.setBounds(143, 28, 37, 21);
				lblNewLabel.setText("\u59D3\u540D");
				
				Label lblNewLabel_1 = new Label(shell, SWT.NONE);
				lblNewLabel_1.setText("\u5BC6\u7801");
				lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
				lblNewLabel_1.setBounds(143, 66, 37, 21);
				
				Label label = new Label(shell, SWT.NONE);
				label.setBounds(127, 153, 61, 17);
				
				text = new Text(shell, SWT.BORDER);
				text.setBounds(201, 29, 108, 23);
				
				text_1 = new Text(shell, SWT.BORDER);
				text_1.setBounds(201, 67, 108, 23);
				
				Label lblNewLabel_2 = new Label(shell, SWT.NONE);
				lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
				lblNewLabel_2.setBounds(143, 129, 30, 21);
				lblNewLabel_2.setText("\u79D1\u5BA4");
				
				text_2 = new Text(shell, SWT.BORDER);
				text_2.setBounds(201, 130, 108, 23);
				
				Label label_1 = new Label(shell, SWT.NONE);
				label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
				label_1.setBounds(143, 170, 37, 21);
				label_1.setText("\u804C\u79F0");
				
				text_3 = new Text(shell, SWT.BORDER);
				text_3.setBounds(201, 170, 108, 23);
				
				Label lblNewLabel_3 = new Label(shell, SWT.NONE);
				lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
				lblNewLabel_3.setBounds(111, 93, 69, 21);
				lblNewLabel_3.setText("\u786E\u8BA4\u5BC6\u7801");
				
				text_4 = new Text(shell, SWT.BORDER);
				text_4.setBounds(201, 96, 108, 23);
			
			Button btnNewButton = new Button(shell, SWT.NONE);
			btnNewButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 16, SWT.BOLD));
			btnNewButton.setBounds(106, 226, 80, 27);
			btnNewButton.setText("\u6CE8\u518C");
			btnNewButton.addSelectionListener(new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					dr.setName(text.getText());
					dr.setPassword(text_1.getText());
					dr.setPwpassword(text_4.getText());
					dr.setSubject(text_2.getText());
					dr.setPosition(text_3.getText());
					ddi.Save(dr);
					MessageBox messagebox = new MessageBox(shell);
					messagebox.setMessage("³É¹¦×¢²á£¡");
					messagebox.open();
				}	
			});	
			Button btnNewButton_1 = new Button(shell, SWT.NONE);
			btnNewButton_1.setFont(SWTResourceManager.getFont("¿¬Ìå", 16, SWT.BOLD));
			btnNewButton_1.setBounds(248, 226, 80, 27);
			btnNewButton_1.setText("\u8FD4\u56DE");
			btnNewButton_1.addSelectionListener(new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					Managermainpage managermain = new Managermainpage();
					shell.dispose();
					managermain.open();
				}
			});	
			}
		});
		rdoctorItem.setText("\u6CE8\u518C\u533B\u751F");
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("\u836F\u54C1\u7BA1\u7406");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.setText("\u4F4F\u9662\u7BA1\u7406");
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("\u57FA\u7840\u8D44\u6599(J)");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem helpmenuItem = new MenuItem(menu, SWT.NONE);
		helpmenuItem.setText("\u5E2E\u52A9(H)");
	}
}
class findSelecter extends SelectionAdapter{
	Findpatient window;
	Shell oldshell;
	public findSelecter(Findpatient window,Shell oldshell){
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