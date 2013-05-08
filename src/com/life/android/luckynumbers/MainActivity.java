package com.life.android.luckynumbers;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Handler numberHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				// Random random1 = new Random();
				// Random random2 = new Random();
				// Random random3 = new Random();
				// Random random4 = new Random();
				// Random random5 = new Random();
				// Random random6 = new Random();
				//
				// number1.setText("" + random1.nextInt(10));
				// number2.setText("" + random2.nextInt(10));
				// number3.setText("" + random3.nextInt(10));
				// number4.setText("" + random4.nextInt(10));
				// number5.setText("" + random5.nextInt(10));
				// number6.setText("" + random6.nextInt(10));

				number1.setText("" + value1);
				number2.setText("" + value2);
				number3.setText("" + value3);
				number4.setText("" + value4);
				number5.setText("" + value5);
				number6.setText("" + value6);
			}
			super.handleMessage(msg);
		}
	};

	private static final int LENGTH_MENU_ID = Menu.FIRST + 1;

	private TableRow numbers;

	private TextView number1;
	private TextView number2;
	private TextView number3;
	private TextView number4;
	private TextView number5;
	private TextView number6;

	private int value1;
	private int value2;
	private int value3;
	private int value4;
	private int value5;
	private int value6;

	private Button runButton;

	private boolean isAlive;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		number1 = (TextView) findViewById(R.id.number1);
		number2 = (TextView) findViewById(R.id.number2);
		number3 = (TextView) findViewById(R.id.number3);
		number4 = (TextView) findViewById(R.id.number4);
		number5 = (TextView) findViewById(R.id.number5);
		number6 = (TextView) findViewById(R.id.number6);

		runButton = (Button) findViewById(R.id.runButton);
		runButton.setText(isAlive ? R.string.stop_button_label
				: R.string.run_button_label);
		runButton.setOnClickListener(this);

		numbers = (TableRow) findViewById(R.id.numbers);
		registerForContextMenu(numbers);
	}

	@Override
	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case R.id.runButton:
			isAlive = isAlive ? false : true;
			runButton.setText(isAlive ? R.string.stop_button_label
					: R.string.run_button_label);

			Thread number1Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random1 = new Random();
						value1 = random1.nextInt(10);
					}
				}

			});
			Thread number2Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random2 = new Random();
						value2 = random2.nextInt(10);
					}
				}

			});

			Thread number3Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random3 = new Random();
						value3 = random3.nextInt(10);
					}
				}

			});

			Thread number4Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random4 = new Random();
						value4 = random4.nextInt(10);
					}
				}

			});

			Thread number5Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random5 = new Random();
						value5 = random5.nextInt(10);
					}
				}

			});

			Thread number6Thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Random random6 = new Random();
						value6 = random6.nextInt(10);
					}
				}

			});

			Thread numbersThread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (isAlive) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						Message msg = numberHandler.obtainMessage();
						msg.what = 1;
						msg.sendToTarget();
					}
				}

			});

			number1Thread.start();
			number2Thread.start();
			number3Thread.start();
			number4Thread.start();
			number5Thread.start();
			number6Thread.start();
			numbersThread.start();
			break;
		}

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View view,
			ContextMenuInfo menuInfo) {
		menu.add(0, LENGTH_MENU_ID, 0, R.string.length_menu_label);
	}

	@Override
	public boolean onContextItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
		case LENGTH_MENU_ID:
			break;
		default:
			break;
		}
		return super.onContextItemSelected(menuItem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
