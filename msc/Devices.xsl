<?xml version="1.0" encoding="UTF-8"?>
<!-- XSL transformation -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:st3="http://knure.kharkov.ua/jt/SummaryTask3" version="1.0">

	<xsl:template match="/st3:devices">
		<html>
			<head>
				<title>Devices</title>
				<style type="text/css">
					td {border: 1px solid black; padding: 5px;}
					table
					{border: 2px solid black;}
				</style>
			</head>
			<body>
				<table>
					<thead>
						<tr>
						<td>Name</td>
						<td>Origin</td>
						<td>Price</td>
						<td>Critical</td>
						<td>Ports</td>
						<td>Peripheral</td>
						<td>Energy consumption</td>
						<td>Cooler</td>
						<td>IO device</td>
						<td>Multimedia</td>
					</tr>
					</thead>
					<xsl:apply-templates select="device" />
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="device">
		<tr>
			<td>
				<xsl:value-of select="Name" />
			</td>
			<td>
				<xsl:value-of select="Origin" />
			</td>
			<td>
				<xsl:value-of select="Price" />
			</td>
			<td>
				<xsl:value-of select="Critical" />
			</td>
			<xsl:apply-templates select="Types" />
		</tr>
	</xsl:template>

	<xsl:template match="Types">
		<td>
			<xsl:value-of select="ports" />
		</td>
		<td>
			<xsl:value-of select="peripheral/@status" />
		</td>
		<td>
			<xsl:value-of select="energyConsumption" />
		</td>
		<td>
			<xsl:value-of select="cooler/@provided" />
		</td>
		<td>
			<xsl:value-of select="group/ioDevice/@provided"/>
		</td>
		<td>
			<xsl:value-of select="group/multimediaDevice/@provided"/>
		</td>
	</xsl:template>

</xsl:stylesheet>