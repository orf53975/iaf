/*
 * $Log: PipeLineProcessorBase.java,v $
 * Revision 1.1  2010-09-13 13:45:09  L190409
 * introduced Processor base classes
 *
 */
package nl.nn.adapterframework.processors;

import nl.nn.adapterframework.util.LogUtil;

import org.apache.log4j.Logger;

/**
 * Baseclass for PipelineProcessors.
 * 
 * @author  Gerrit van Brakel
 * @since   4.11
 * @version Id
 */
public abstract class PipeLineProcessorBase implements PipeLineProcessor {
	protected Logger log = LogUtil.getLogger(this);

	protected PipeLineProcessor pipeLineProcessor;

	public void setPipeLineProcessor(PipeLineProcessor pipeLineProcessor) {
		this.pipeLineProcessor = pipeLineProcessor;
	}
	
}