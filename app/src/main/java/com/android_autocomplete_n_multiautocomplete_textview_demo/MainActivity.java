package com.android_autocomplete_n_multiautocomplete_textview_demo;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static AutoCompleteTextView autoComplete_textView;
	private static MultiAutoCompleteTextView multiautoComplete_textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		autoComplete_textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		multiautoComplete_textView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);

		// Calling the suggestions method
		setSuggestions();
	}

	void setSuggestions() {

		// Getting the string array from strings.xml
		String items[] = getResources().getStringArray(R.array.suggest_items);

		// New Arrays list for storing items
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < items.length; i++) {

			// Adding items to arary list
			list.add(items[i]);
		}

		// Adapter for holding the data view
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_1, list);

		// Setting adapter to both textviews
		autoComplete_textView.setAdapter(adapter);
		multiautoComplete_textView.setAdapter(adapter);

		// Specify the minimum type of characters before drop-down list is shown
		autoComplete_textView.setThreshold(1);
		multiautoComplete_textView.setThreshold(1);

		// comma to separate the different items
		multiautoComplete_textView
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

		// When the user clicks an item of the drop-down list an toast will
		// shown
		multiautoComplete_textView
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int pos,

							long id) {

						Toast.makeText(
								MainActivity.this,
								"MultiAutoComplete: " +

								"you add new item "
										+ parent.getItemAtPosition(pos),

								Toast.LENGTH_SHORT).show();

					}

				});

	}

}
