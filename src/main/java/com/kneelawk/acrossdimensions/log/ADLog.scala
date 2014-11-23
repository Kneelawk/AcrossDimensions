package com.kneelawk.acrossdimensions.log

import org.apache.logging.log4j.Logger

object ADLog {
	var log: Logger = null

	def init(log: Logger) {
		this.log = log
	}

	def debug(a: Any) {
		log.debug(a)
	}

	def debug(a: Any, t: Throwable) {
		log.debug(a, t)
	}

	def info(a: Any) {
		log.info(a)
	}

	def info(a: Any, t: Throwable) {
		log.info(a, t)
	}

	def warn(a: Any) {
		log.warn(a)
	}

	def warp(a: Any, t: Throwable) {
		log.warn(a, t)
	}

	def error(a: Any) {
		log.error(a)
	}

	def error(a: Any, t: Throwable) {
		log.error(a, t)
	}

	def fatal(a: Any) {
		log.fatal(a)
	}

	def fatal(a: Any, t: Throwable) {
		log.fatal(a, t)
	}
}