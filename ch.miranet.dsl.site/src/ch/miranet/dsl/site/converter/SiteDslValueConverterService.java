package ch.miranet.dsl.site.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;

public class SiteDslValueConverterService extends DefaultTerminalConverters {
	
	@Inject private INTROValueConverter introValueConverter;
	@Inject private BODYValueConverter bodyValueConverter;

	@ValueConverter(rule="INTRO")
	public IValueConverter<String> INTRO() {
		return introValueConverter;
	}
	
	@ValueConverter(rule="BODY")
	public IValueConverter<String> BODY() {
		return bodyValueConverter;
	}
	
}
